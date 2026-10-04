package com.example.legacy;

/** Wrapper constructors are deprecated for removal since Java 9. */
public class LegacyBoxing {

    public Integer box(int value) {
        return Integer.valueOf(value);
    }

    public Boolean parse(String text) {
        return Boolean.valueOf(text);
    }

    public boolean sameReference(int a, int b) {
        return Integer.valueOf(a) == Integer.valueOf(b); // always false
    }
}
