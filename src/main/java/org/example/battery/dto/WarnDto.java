package org.example.battery.dto;


import lombok.Data;


@Data
public class WarnDto {
    private Integer carId;
    private String type;
    private String warnName;
    private Integer warnLevel;
}
