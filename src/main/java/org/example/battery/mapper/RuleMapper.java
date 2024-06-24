package org.example.battery.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.battery.entity.Car;
import org.example.battery.entity.Rule;

import java.util.List;

public interface RuleMapper {
    Rule getRuleByWarnIdAndBatteryType(@Param("ruleId") Integer ruleId, @Param("batteryType") Integer batteryType);
    List<Rule> selectByBatteryType(@Param("batteryType") Integer batteryType);
}
