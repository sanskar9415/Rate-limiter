package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InaccessibleObjectException;

import org.junit.jupiter.api.Test;

class LegacyReflectionTest {

    @Test
    void javaSeventeenBlocksAccessToStringInternals() {
        assertThrows(InaccessibleObjectException.class,
                () -> new LegacyReflection().peekStringInternals("abc"));
    }
}