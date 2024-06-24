package org.example.battery.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.battery.common.Result;
import org.example.battery.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/battery")
@Slf4j
public class BatteryController {
    @Autowired
    private BatteryService batteryService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getTypeId")
    public Result getBatteryTypeId(String name){
        return Result.success(batteryService.getTypeId(name));
    }
}
