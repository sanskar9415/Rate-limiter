package com.example.legacy;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class LegacyEncoder {

    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    public String decode(String encoded) {
        return new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
    }
}