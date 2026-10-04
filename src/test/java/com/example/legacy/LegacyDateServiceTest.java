package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

class LegacyDateServiceTest {

    private final LegacyDateService service = new LegacyDateService();

    @Test
    void yearOfRoundTrips() {
        Date date = service.of(2020, 1, 15);
        assertEquals(2020, service.yearOf(date));
    }

    @Test
    void currentThreadIdIsPositive() {
        assertTrue(service.currentThreadId() > 0);
    }
}
