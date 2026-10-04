package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LegacyEncoderTest {

    private final LegacyEncoder encoder = new LegacyEncoder();

    @Test
    void encodesToBase64() throws Exception {
        assertEquals("aGVsbG8=", encoder.encode("hello"));
    }

    @Test
    void roundTrips() throws Exception {
        assertEquals("hello", encoder.decode(encoder.encode("hello")));
    }
}
