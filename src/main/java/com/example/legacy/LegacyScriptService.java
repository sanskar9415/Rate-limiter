package com.example.legacy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/** Nashorn JavaScript engine was removed in Java 15: getEngineByName returns null. */
public class LegacyScriptService {

    public int evaluate(String expression) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        return ((Number) engine.eval(expression)).intValue();
    }
}
