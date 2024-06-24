package org.example.battery.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.example.battery.entity.Car;

/**
 * @author 14273
 */
public interface CarService {
    Boolean save(Car car);
    Car selectByCarId(Integer carId);
}
