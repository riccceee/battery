package org.example.battery.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculate {
    public static Boolean calculate(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Boolean result = (Boolean) engine.eval(expression);
            return result;
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}
