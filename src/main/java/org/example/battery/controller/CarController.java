package org.example.battery.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.battery.common.Result;
import org.example.battery.dto.CarDto;
import org.example.battery.entity.Car;
import org.example.battery.service.BatteryService;
import org.example.battery.service.CarService;
import org.example.battery.util.UUID16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author 14273
 */
@RestController
@Slf4j
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private BatteryService batteryService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/save")
    public Result saveCar(@RequestBody CarDto carDto) {
        Car car = new Car();
        Integer id = null;
        if(stringRedisTemplate.opsForValue().get(carDto.getType()) != null){
            id = Integer.parseInt(stringRedisTemplate.opsForValue().get(carDto.getType()));
        }else {
            id = batteryService.getTypeId(carDto.getType());
        }
        car.setVid(UUID16.getUUID());
        car.setMile(carDto.getMile());
        car.setPercent(carDto.getPercent());
        car.setType(id);
        if(carService.save(car)) {
            return Result.success();
        }
        return Result.error(500,"添加失败");
    }
}
