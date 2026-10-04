package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LegacyScriptServiceTest {

    @Test
    void evaluatesJavaScript() throws Exception {
        assertEquals(7, new LegacyScriptService().evaluate("3 + 4"));
    }
}
