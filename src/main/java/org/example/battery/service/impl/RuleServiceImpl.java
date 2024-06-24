package org.example.battery.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.ior.FreezableList;
import lombok.extern.slf4j.Slf4j;
import org.example.battery.dto.*;
import org.example.battery.entity.Car;
import org.example.battery.entity.Rule;
import org.example.battery.mapper.BatteryMapper;
import org.example.battery.mapper.CarMapper;
import org.example.battery.mapper.RuleMapper;
import org.example.battery.service.BatteryService;
import org.example.battery.service.CarService;
import org.example.battery.service.RuleService;
import org.example.battery.util.Calculate;
import org.example.battery.util.MatchRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RuleServiceImpl implements RuleService {
    private static final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RuleMapper ruleMapper;
    @Autowired
    private BatteryService batteryService;
    @Autowired
    private CarService carService;

    @Override
    public List<WarnDto> warn(List<QueryDto> queryDtoList) throws JsonProcessingException {
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        List<WarnDto> resWarn = new ArrayList<>();
        CarDto carDto = new CarDto();
        Car car = null;
        for(QueryDto queryDto : queryDtoList) {
            // 根据传入的carId获取对应的汽车的的数据
            if(stringRedisTemplate.opsForValue().get("car:" + queryDto.getCarId()) == null) {
                car = carService.selectByCarId(queryDto.getCarId());
                carDto.setByCar(car);
                if(Integer.valueOf(batteryService.getTypeId("三元电池")).equals(car.getType()) ) {
                    carDto.setType("三元电池");
                } else {
                    carDto.setType("铁锂电池");
                }
                String carJson = mapper.writeValueAsString(carDto);
                stringRedisTemplate.opsForValue().set("car:" + queryDto.getCarId(), carJson);
            }else {
                carDto = mapper.readValue(stringRedisTemplate.opsForValue().get("car:" + queryDto.getCarId()), CarDto.class);
            }
            // 获取rule数据
            if(queryDto.getWarnId() != null){
                // 如果warnID不为空就去获取warnId对应的规则
                Rule rule = null;
                if(stringRedisTemplate.opsForValue().get("rule:"+queryDto.getWarnId()+":"+carDto.getType()) == null) {
                    // redis中没有
                    rule = ruleMapper.getRuleByWarnIdAndBatteryType(queryDto.getWarnId(), batteryService.getTypeId(carDto.getType()));
                    String ruleJson = mapper.writeValueAsString(rule);
                    stringRedisTemplate.opsForValue().set("rule:"+queryDto.getWarnId()+":"+carDto.getType(), ruleJson);
                } else {
                    // redis中有
                    String  ruleJson = stringRedisTemplate.opsForValue().get("rule:"+queryDto.getWarnId()+":"+carDto.getType());
                    rule = mapper.readValue(ruleJson, Rule.class);
                }
                List<RuleDto> ruleDto = mapper.readValue(rule.getRule(),mapper.getTypeFactory().constructCollectionType(List.class,RuleDto.class));
                for (RuleDto ruleDto1 : ruleDto) {
                    WarnDto warnDto = MatchRule.matchRule(queryDto,ruleDto1,carDto,rule);
                    if(warnDto != null) {
                        resWarn.add(warnDto);
                    }
                }
            } else {
                // warnID为空时，根据电池类型来遍历规则
                List<Rule> ruleList = ruleMapper.selectByBatteryType(batteryService.getTypeId(carDto.getType()));
                for (Rule rule : ruleList) {
                    List<RuleDto> ruleDto2 = mapper.readValue(rule.getRule(), mapper.getTypeFactory().constructCollectionType(List.class,RuleDto.class));
                    for(RuleDto ruleDto : ruleDto2) {
                        WarnDto warnDto = MatchRule.matchRule(queryDto,ruleDto,carDto,rule);
                        if(warnDto != null) {
                            resWarn.add(warnDto);
                        }
                    }

                }
            }
        }
        return resWarn;
    }

}
