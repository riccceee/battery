package org.example.battery.dto;

import lombok.Data;
import org.example.battery.entity.Car;

/**
 * @author 14273
 */
@Data
public class CarDto {
    private String vid;
    private Integer carId;
    private String type;
    private Integer mile;
    private Integer percent;

    public void setByCar(Car car){
        this.vid = car.getVid();
        this.carId = car.getCarId();
        this.mile = car.getMile();
        this.percent = car.getPercent();
    }
}
