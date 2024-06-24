package org.example.battery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.battery.dto.RuleDto;
import org.example.battery.dto.SignalDto;
import org.example.battery.service.CarService;
import org.example.battery.util.Calculate;
import org.example.battery.util.UUID16;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sun.util.resources.cldr.aa.CurrencyNames_aa;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
class BatteryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "  {\n" +
                        "    \"carId\": 1,\n" +
                        "    \"warnId\": 1,\n" +
                        "    \"signal\": \"{\\\"Mx\\\":12.0,\\\"Mi\\\":0.6}\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"carId\": 2,\n" +
                        "    \"warnId\": 2,\n" +
                        "    \"signal\": \"{\\\"Ix\\\":12.0,\\\"Ii\\\":11.7}\"\n" +
                        "  },\n" +
                        "   {\n" +
                        "    \"carId\": 3,\n" +
                        "    \"signal\": \"{\\\"Mx\\\":11.0,\\\"Mi\\\":9.6,\\\"Ix\\\":12.0,\\\"Ii\\\":11.7}\"\n" +
                        "  }\n" +
                        "]")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void test1() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\n" +
                        "        \"carId\": 2,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":12.0,\\\"Mi\\\":0.6}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":10.5,\\\"Mi\\\":0.8}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":15.2,\\\"Mi\\\":0.3}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":11.7,\\\"Mi\\\":0.9}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":13.5,\\\"Mi\\\":0.7}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":9.8,\\\"Mi\\\":0.5}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":14.6,\\\"Mi\\\":0.4}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":12.9,\\\"Mi\\\":0.6}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":11.2,\\\"Mi\\\":0.8}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":13.8,\\\"Mi\\\":0.3}\"\n" +
                        "    }\n" +
                        "]\n")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
    @Test
    void test2() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":12.0,\\\"Mi\\\":0.6}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":10.5,\\\"Mi\\\":0.8}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":15.2,\\\"Mi\\\":0.3}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":11.7,\\\"Mi\\\":0.9}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":13.5,\\\"Mi\\\":0.7}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":9.8,\\\"Mi\\\":0.5}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":14.6,\\\"Mi\\\":0.4}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":12.9,\\\"Mi\\\":0.6}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":11.2,\\\"Mi\\\":0.8}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"carId\": 1,\n" +
                        "        \"warnId\": 1,\n" +
                        "        \"signal\": \"{\\\"Mx\\\":13.8,\\\"Mi\\\":0.3}\"\n" +
                        "    }\n" +
                        "]\n")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
    @Test
    void test3() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\n" +
                        "      \"carId\": 3,\n" +
                        "      \"warnId\": 1,\n" +
                        "      \"signal\": \"{\\\"Mx\\\":12.3,\\\"Mi\\\":7.9}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"carId\": 3,\n" +
                        "      \"warnId\": 1,\n" +
                        "      \"signal\": \"{\\\"Mx\\\":13.5,\\\"Mi\\\":8.8}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"carId\": 2,\n" +
                        "      \"warnId\": 1,\n" +
                        "      \"signal\": \"{\\\"Mx\\\":11.2,\\\"Mi\\\":6.8}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"carId\": 2,\n" +
                        "      \"warnId\": 1,\n" +
                        "      \"signal\": \"{\\\"Mx\\\":10.6,\\\"Mi\\\":5.2}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"carId\": 2,\n" +
                        "      \"warnId\": 1,\n" +
                        "      \"signal\": \"{\\\"Mx\\\":14.1,\\\"Mi\\\":9.6}\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"carId\": 3,\n" +
                        "      \"warnId\": 2,\n" +
                        "      \"signal\": \"{\\\"Ix\\\":5.0,\\\"Ii\\\":0.8}\"\n" +
                        "    }\n" +
                        "]\n")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
    @Test
    void test4() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.8,\\\"Mi\\\":6.3}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.0,\\\"Ii\\\":9.1}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":14.2,\\\"Mi\\\":9.5}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":7.5,\\\"Ii\\\":5.1}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":8.3,\\\"Mi\\\":3.5}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":10.9,\\\"Ii\\\":6.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.1,\\\"Mi\\\":8.2}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":12.5,\\\"Mi\\\":8.0}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.3,\\\"Mi\\\":6.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.8,\\\"Ii\\\":8.9}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":14.0,\\\"Ii\\\":10.2}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":7.1,\\\"Mi\\\":4.9}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.7,\\\"Mi\\\":6.9}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.0,\\\"Mi\\\":8.4}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.4,\\\"Ii\\\":9.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.8,\\\"Ii\\\":7.9}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":9.1,\\\"Ii\\\":5.0}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":8.4,\\\"Mi\\\":4.6}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.9,\\\"Mi\\\":6.4}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":14.1,\\\"Mi\\\":9.3}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.8,\\\"Ii\\\":10.1}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":7.6,\\\"Mi\\\":3.1}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.0,\\\"Ii\\\":6.9}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.5,\\\"Mi\\\":8.1}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.3,\\\"Ii\\\":9.6}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":8.8,\\\"Mi\\\":5.6}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.3,\\\"Ii\\\":8.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":12.6,\\\"Mi\\\":10.0}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.1,\\\"Ii\\\":9.2}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.7,\\\"Mi\\\":4.8}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":10.1,\\\"Ii\\\":6.3}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":12.2,\\\"Mi\\\":7.4}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":14.3,\\\"Ii\\\":10.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.2,\\\"Mi\\\":5.3}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":8.7,\\\"Ii\\\":6.2}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":12.9,\\\"Mi\\\":8.3}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.2,\\\"Ii\\\":9.5}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.9,\\\"Mi\\\":8.6}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":9.2,\\\"Ii\\\":5.4}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":8.5,\\\"Mi\\\":4.2}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.0,\\\"Ii\\\":8.0}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":14.5,\\\"Mi\\\":9.7}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":9.8,\\\"Ii\\\":6.5}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.2,\\\"Mi\\\":7.8}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":10.5,\\\"Ii\\\":8.8}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":12.9,\\\"Mi\\\":9.6}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":7.3,\\\"Ii\\\":5.4}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.5,\\\"Mi\\\":6.1}\"}\n" +
                        "]\n")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
    @Test
    void test5() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":9.8,\\\"Mi\\\":6.3,\\\"Ix\\\":12.0,\\\"Ii\\\":9.1}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":14.2,\\\"Mi\\\":9.5,\\\"Ix\\\":10.9,\\\"Ii\\\":6.5}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":8.3,\\\"Mi\\\":3.5,\\\"Ix\\\":11.1,\\\"Ii\\\":8.2}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.5,\\\"Mi\\\":8.0,\\\"Ix\\\":13.0,\\\"Ii\\\":8.4}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":9.3,\\\"Mi\\\":6.0,\\\"Ix\\\":11.8,\\\"Ii\\\":8.9}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":14.0,\\\"Mi\\\":10.2,\\\"Ix\\\":7.1,\\\"Ii\\\":4.9}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.7,\\\"Mi\\\":6.9,\\\"Ix\\\":13.3,\\\"Ii\\\":9.6}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":8.8,\\\"Mi\\\":5.6,\\\"Ix\\\":11.3,\\\"Ii\\\":8.5}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":12.6,\\\"Mi\\\":10.0,\\\"Ix\\\":10.1,\\\"Ii\\\":6.3}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":11.9,\\\"Mi\\\":8.6,\\\"Ix\\\":12.0,\\\"Ii\\\":8.0}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":14.5,\\\"Mi\\\":9.7,\\\"Ix\\\":9.8,\\\"Ii\\\":6.5}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":8.4,\\\"Mi\\\":4.6,\\\"Ix\\\":12.2,\\\"Ii\\\":7.4}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":13.8,\\\"Mi\\\":10.1,\\\"Ix\\\":8.7,\\\"Ii\\\":6.2}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":7.6,\\\"Mi\\\":3.1,\\\"Ix\\\":14.3,\\\"Ii\\\":10.5}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":12.9,\\\"Mi\\\":8.3,\\\"Ix\\\":10.5,\\\"Ii\\\":8.8}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":8.5,\\\"Mi\\\":4.2,\\\"Ix\\\":9.2,\\\"Ii\\\":5.4}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":9.5,\\\"Mi\\\":6.1,\\\"Ix\\\":13.2,\\\"Ii\\\":9.5}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":13.1,\\\"Mi\\\":9.2,\\\"Ix\\\":12.9,\\\"Ii\\\":9.6}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":7.3,\\\"Mi\\\":5.4,\\\"Ix\\\":9.5,\\\"Ii\\\":6.1}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":10.2,\\\"Mi\\\":5.3,\\\"Ix\\\":12.5,\\\"Ii\\\":8.3}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":11.4,\\\"Mi\\\":9.0,\\\"Ix\\\":13.7,\\\"Ii\\\":10.6}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":11.0,\\\"Mi\\\":6.9,\\\"Ix\\\":10.7,\\\"Ii\\\":6.9}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":12.6,\\\"Mi\\\":9.0,\\\"Ix\\\":9.6,\\\"Ii\\\":6.0}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":13.3,\\\"Mi\\\":9.6,\\\"Ix\\\":12.3,\\\"Ii\\\":8.9}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":8.8,\\\"Mi\\\":5.1,\\\"Ix\\\":13.2,\\\"Ii\\\":9.4}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":9.1,\\\"Mi\\\":5.0,\\\"Ix\\\":12.1,\\\"Ii\\\":7.5}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":14.2,\\\"Mi\\\":9.5,\\\"Ix\\\":10.9,\\\"Ii\\\":6.5}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":8.3,\\\"Mi\\\":3.5,\\\"Ix\\\":11.1,\\\"Ii\\\":8.2}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":12.5,\\\"Mi\\\":8.0,\\\"Ix\\\":13.0,\\\"Ii\\\":8.4}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":9.3,\\\"Mi\\\":6.0,\\\"Ix\\\":11.8,\\\"Ii\\\":8.9}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":14.0,\\\"Mi\\\":10.2,\\\"Ix\\\":7.1,\\\"Ii\\\":4.9}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":10.7,\\\"Mi\\\":6.9,\\\"Ix\\\":13.3,\\\"Ii\\\":9.6}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":8.8,\\\"Mi\\\":5.6,\\\"Ix\\\":11.3,\\\"Ii\\\":8.5}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.6,\\\"Mi\\\":10.0,\\\"Ix\\\":10.1,\\\"Ii\\\":6.3}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":11.9,\\\"Mi\\\":8.6,\\\"Ix\\\":12.0,\\\"Ii\\\":8.0}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":14.5,\\\"Mi\\\":9.7,\\\"Ix\\\":9.8,\\\"Ii\\\":6.5}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":8.4,\\\"Mi\\\":4.6,\\\"Ix\\\":12.2,\\\"Ii\\\":7.4}\"},\n" +
                        "    {\"carId\": 2, \"signal\": \"{\\\"Mx\\\":13.8,\\\"Mi\\\":10.1,\\\"Ix\\\":8.7,\\\"Ii\\\":6.2}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":7.6,\\\"Mi\\\":3.1,\\\"Ix\\\":14.3,\\\"Ii\\\":10.5}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.9,\\\"Mi\\\":8.3,\\\"Ix\\\":10.5,\\\"Ii\\\":8.8}\"}\n" +
                        "]\n")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
    @Test
    void test6() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.2, \\\"Mi\\\":8.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.3, \\\"Ii\\\":10.0}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":9.5, \\\"Mi\\\":7.0, \\\"Ix\\\":11.0, \\\"Ii\\\":9.0}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":14.0, \\\"Mi\\\":12.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.5, \\\"Ii\\\":11.2}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":8.9, \\\"Mi\\\":6.5, \\\"Ix\\\":10.4, \\\"Ii\\\":8.7}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":11.5, \\\"Mi\\\":10.0, \\\"Ix\\\":13.0, \\\"Ii\\\":11.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.7, \\\"Mi\\\":11.0}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":14.5, \\\"Ii\\\":12.0}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.8, \\\"Mi\\\":8.5, \\\"Ix\\\":12.7, \\\"Ii\\\":11.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.1, \\\"Mi\\\":7.5}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":10.9, \\\"Ii\\\":8.8}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.3, \\\"Mi\\\":10.5, \\\"Ix\\\":14.0, \\\"Ii\\\":12.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.4, \\\"Mi\\\":9.0}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.8, \\\"Ii\\\":10.4}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":9.7, \\\"Mi\\\":7.2, \\\"Ix\\\":11.5, \\\"Ii\\\":9.3}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.0, \\\"Mi\\\":11.5}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.7, \\\"Ii\\\":11.5}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.6, \\\"Mi\\\":8.3, \\\"Ix\\\":12.2, \\\"Ii\\\":12.0}\"}\n" +
                        "]")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
    @Test
    void test7() throws Exception {;
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/warn")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.0, \\\"Mi\\\":8.2}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.9, \\\"Ii\\\":10.3}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":9.4, \\\"Mi\\\":7.8, \\\"Ix\\\":11.2, \\\"Ii\\\":9.5}\"},\n" +
                        "    {\"carId\": 1, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.5, \\\"Mi\\\":12.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.7, \\\"Ii\\\":11.1}\"},\n" +
                        "    {\"carId\": 3, \"signal\": \"{\\\"Mx\\\":8.5, \\\"Mi\\\":6.9, \\\"Ix\\\":10.1, \\\"Ii\\\":8.4}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":11.0, \\\"Mi\\\":9.5, \\\"Ix\\\":12.5, \\\"Ii\\\":11.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":14.2, \\\"Mi\\\":11.9}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.8, \\\"Ii\\\":12.3}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.9, \\\"Mi\\\":9.0, \\\"Ix\\\":13.3, \\\"Ii\\\":11.6}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.3, \\\"Mi\\\":8.5}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.0, \\\"Ii\\\":10.5}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.7, \\\"Mi\\\":10.9, \\\"Ix\\\":14.2, \\\"Ii\\\":12.1}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.6, \\\"Mi\\\":9.8}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":14.1, \\\"Ii\\\":12.0}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":9.8, \\\"Mi\\\":7.7, \\\"Ix\\\":11.8, \\\"Ii\\\":9.4}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.3, \\\"Mi\\\":11.2}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.9, \\\"Ii\\\":11.4}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.5, \\\"Mi\\\":8.8, \\\"Ix\\\":12.1, \\\"Ii\\\":10.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":9.9, \\\"Mi\\\":7.6}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.6, \\\"Ii\\\":9.7}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.2, \\\"Mi\\\":10.1, \\\"Ix\\\":13.7, \\\"Ii\\\":11.2}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.2, \\\"Mi\\\":9.1}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.3, \\\"Ii\\\":11.6}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.7, \\\"Mi\\\":8.9, \\\"Ix\\\":12.5, \\\"Ii\\\":10.2}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":14.1, \\\"Mi\\\":12.3}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":14.4, \\\"Ii\\\":12.8}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":11.6, \\\"Mi\\\":9.5, \\\"Ix\\\":13.9, \\\"Ii\\\":11.4}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.2, \\\"Mi\\\":8.2}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.1, \\\"Ii\\\":10.3}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.6, \\\"Mi\\\":10.4, \\\"Ix\\\":14.3, \\\"Ii\\\":11.8}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.5, \\\"Mi\\\":9.4}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.1, \\\"Ii\\\":11.7}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":9.6, \\\"Mi\\\":7.4, \\\"Ix\\\":11.4, \\\"Ii\\\":9.1}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.7, \\\"Mi\\\":11.9}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":14.6, \\\"Ii\\\":12.2}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.4, \\\"Mi\\\":8.6, \\\"Ix\\\":12.9, \\\"Ii\\\":10.3}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.7, \\\"Mi\\\":8.8}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.5, \\\"Ii\\\":9.8}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":12.8, \\\"Mi\\\":10.7, \\\"Ix\\\":14.1, \\\"Ii\\\":11.5}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":11.9, \\\"Mi\\\":9.6}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":13.9, \\\"Ii\\\":11.9}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":9.3, \\\"Mi\\\":7.1, \\\"Ix\\\":11.1, \\\"Ii\\\":9.0}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":13.2, \\\"Mi\\\":11.0}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":12.5, \\\"Ii\\\":10.6}\"},\n" +
                        "    {\"carId\": 1, \"signal\": \"{\\\"Mx\\\":10.8, \\\"Mi\\\":8.7, \\\"Ix\\\":12.6, \\\"Ii\\\":10.4}\"},\n" +
                        "    {\"carId\": 2, \"warnId\": 1, \"signal\": \"{\\\"Mx\\\":10.5, \\\"Mi\\\":8.3}\"},\n" +
                        "    {\"carId\": 3, \"warnId\": 2, \"signal\": \"{\\\"Ix\\\":11.8, \\\"Ii\\\":10.0}\"}\n" +
                        "]\n")
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
}
