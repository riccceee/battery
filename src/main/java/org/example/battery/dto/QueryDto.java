package org.example.battery.dto;

import lombok.Data;

@Data
public class QueryDto {
    private Integer carId;
    private Integer warnId;
    private String signal;
}
