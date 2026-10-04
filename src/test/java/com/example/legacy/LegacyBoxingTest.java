package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LegacyBoxingTest {

    private final LegacyBoxing boxing = new LegacyBoxing();

    @Test
    void boxesValue() {
        assertEquals(Integer.valueOf(42), boxing.box(42));
    }

    @Test
    void parsesBoolean() {
        assertTrue(boxing.parse("true"));
        assertFalse(boxing.parse("nope"));
    }

    @Test
    void newWrapperIsAlwaysDifferentReference() {
        assertFalse(boxing.sameReference(1, 1));
    }
}
