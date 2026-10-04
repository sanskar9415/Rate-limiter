package com.example.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LegacyXmlServiceTest {

    private final LegacyXmlService service = new LegacyXmlService();

    @Test
    void marshalsToXml() throws Exception {
        String xml = service.toXml(new Person("Asha", 30));
        assertTrue(xml.contains("<name>Asha</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void roundTrips() throws Exception {
        Person back = service.fromXml(service.toXml(new Person("Asha", 30)));
        assertEquals("Asha", back.name);
        assertEquals(30, back.age);
    }
}
