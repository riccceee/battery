package org.example.battery.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 14273
 */
public interface BatteryMapper {
    Integer getTypeId(String name);
}
