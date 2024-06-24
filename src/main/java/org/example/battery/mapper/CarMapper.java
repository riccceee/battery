package org.example.battery.mapper;

import org.example.battery.entity.Car;

/**
 * @author 14273
 */
public interface CarMapper {
    Boolean save(Car car);
    Car selectByCarId(Integer id);
}
