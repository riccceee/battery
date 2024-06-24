package org.example.battery.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.battery.dto.*;
import org.example.battery.entity.Rule;

public class MatchRule {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static WarnDto matchRule(QueryDto queryDto, RuleDto rule, CarDto carDto, Rule r) throws JsonProcessingException {
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        SignalDto signalDto = mapper.readValue(queryDto.getSignal(), SignalDto.class);
        String expression = rule.getWarnExpression();
        Integer warnLevel = rule.getWarnLevel();
        if(queryDto.getWarnId() != null) {
            if(queryDto.getWarnId() == 1) {
                expression = expression.replaceAll("Mx", String.valueOf(signalDto.getMx()));
                expression = expression.replaceAll("Mi", String.valueOf(signalDto.getMi()));
            } else {
                expression = expression.replaceAll("Ix", String.valueOf(signalDto.getIx()));
                expression = expression.replaceAll("Ii", String.valueOf(signalDto.getIi()));
            }
        }else {
            if(r.getRuleId() == 1) {
                expression = expression.replaceAll("Mx", String.valueOf(signalDto.getMx()));
                expression = expression.replaceAll("Mi", String.valueOf(signalDto.getMi()));
            } else {
                expression = expression.replaceAll("Ix", String.valueOf(signalDto.getIx()));
                expression = expression.replaceAll("Ii", String.valueOf(signalDto.getIi()));
            }
        }

        if(Calculate.calculate(expression)) {
            WarnDto warnDto = new WarnDto();
            warnDto.setCarId(carDto.getCarId());
            warnDto.setType(carDto.getType());
            warnDto.setWarnName(r.getWarnName());
            if(warnLevel != -1) {
                warnDto.setWarnLevel(warnLevel);
            } else {
                warnDto.setWarnLevel(null);
            }
            return warnDto;
        }
        return null;
    }
}
