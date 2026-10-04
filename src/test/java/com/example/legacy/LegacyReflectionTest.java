package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class LegacyReflectionTest {

    @Test
    void readsInternalCharArray() throws Exception {
        Object value = new LegacyReflection().peekStringInternals("abc");
        assertArrayEquals("abc".toCharArray(), (char[]) value);
    }
}
