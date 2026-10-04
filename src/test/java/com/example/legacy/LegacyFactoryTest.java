package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LegacyFactoryTest {

    @Test
    void createsInstanceViaNoArgConstructor() throws Exception {
        assertNotNull(new LegacyFactory().create(StringBuilder.class));
    }
}
