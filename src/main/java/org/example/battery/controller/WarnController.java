package org.example.battery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.example.battery.common.Result;
import org.example.battery.dto.QueryDto;
import org.example.battery.dto.WarnDto;
import org.example.battery.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/warn")
public class WarnController {
    @Autowired
    private RuleService ruleService;
    @PostMapping
    public Result<List<WarnDto>> warn(@RequestBody List<QueryDto> queryDtoList) throws JsonProcessingException {
        //log.info(queryDtoList.toString());
        return Result.success(ruleService.warn(queryDtoList));
    }
}
