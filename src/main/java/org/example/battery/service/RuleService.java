package org.example.battery.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.battery.dto.QueryDto;
import org.example.battery.dto.WarnDto;
import org.example.battery.entity.Rule;

import java.util.List;

public interface RuleService {
    List<WarnDto> warn(List<QueryDto> queryDtoList) throws JsonProcessingException;
}
