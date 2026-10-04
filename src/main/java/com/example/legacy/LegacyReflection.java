package com.example.legacy;

import java.lang.reflect.Field;

/**
 * Reads String's private field. Works on Java 8 (char[]).
 * Java 17: InaccessibleObjectException (strong encapsulation).
 * Even with --add-opens, the field is byte[] since Java 9.
 */
public class LegacyReflection {

    public Object peekStringInternals(String s) throws Exception {
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        return field.get(s);
    }
}
