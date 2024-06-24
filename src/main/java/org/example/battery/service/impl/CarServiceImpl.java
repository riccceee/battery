package org.example.battery.service.impl;

import org.example.battery.entity.Car;
import org.example.battery.mapper.CarMapper;
import org.example.battery.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 14273
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Boolean save(Car car) {
        return carMapper.save(car);
    }

    @Override
    public Car selectByCarId(Integer carId) {
        return carMapper.selectByCarId(carId);
    }
}
