package com.example.legacy;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/** JAXB was bundled with Java 8, removed from the JDK in Java 11. */
public class LegacyXmlService {

    public String toXml(Person person) throws Exception {
        Marshaller marshaller = JAXBContext.newInstance(Person.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        StringWriter out = new StringWriter();
        marshaller.marshal(person, out);
        return out.toString();
    }

    public Person fromXml(String xml) throws Exception {
        return (Person) JAXBContext.newInstance(Person.class)
                .createUnmarshaller().unmarshal(new StringReader(xml));
    }
}
