package org.example.battery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {
    private Integer id;
    private Integer ruleId;
    private String warnName;
    private Integer type;
    private String rule;
}
