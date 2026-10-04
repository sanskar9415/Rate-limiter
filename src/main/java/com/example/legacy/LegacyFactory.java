package com.example.legacy;

/** Class.newInstance() is deprecated since Java 9. */
public class LegacyFactory {

    public <T> T create(Class<T> type) throws Exception {
        return type.newInstance();
    }
}
