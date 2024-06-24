package org.example.battery.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.battery.common.Result;
import org.example.battery.mapper.BatteryMapper;
import org.example.battery.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



/**
 * @author 14273
 */
@Slf4j
@Service
public class BatteryServiceImpl implements BatteryService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private BatteryMapper batteryMapper;

    @Override
    public Integer getTypeId(String name) {
        if(stringRedisTemplate.opsForValue().get(name) != null){
            // log.info("not null");
            return Integer.valueOf(stringRedisTemplate.opsForValue().get(name));
        }
        Integer id = batteryMapper.getTypeId(name);
        stringRedisTemplate.opsForValue().set(name, String.valueOf(id));
        return id;
    }
}
