package com.example.legacy;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** Internal sun.misc API: exists on Java 8, REMOVED in Java 9+ (compile error). */
public class LegacyEncoder {

    public String encode(String text) throws IOException {
        return new BASE64Encoder().encode(text.getBytes("UTF-8"));
    }

    public String decode(String encoded) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(encoded), "UTF-8");
    }
}
