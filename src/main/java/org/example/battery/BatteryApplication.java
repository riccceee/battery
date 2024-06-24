package org.example.battery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 14273
 */
@SpringBootApplication
@MapperScan("org.example.battery.mapper")
public class BatteryApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatteryApplication.class, args);
    }
}
