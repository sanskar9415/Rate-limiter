package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LegacyResourceTest {

    @Test
    void closeMarksClosed() {
        LegacyResource resource = new LegacyResource();
        assertFalse(resource.isClosed());
        resource.close();
        assertTrue(resource.isClosed());
    }
}
