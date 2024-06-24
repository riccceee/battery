package org.example.battery.entity;

import lombok.Data;

/**
 * @author 14273
 */
@Data
public class Car {
    private String vid;
    private Integer carId;
    private Integer type;
    private Integer mile;
    private Integer percent;
}
