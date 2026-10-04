package com.example.legacy;

import java.util.Date;

/** Uses long-deprecated java.util.Date APIs. Compiles with warnings on 8 and 17. */
public class LegacyDateService {

    public Date of(int year, int month, int day) {
        return new Date(year - 1900, month - 1, day);
    }

    public int yearOf(Date date) {
        return date.getYear() + 1900;
    }

    /** Thread.getId() is deprecated since Java 19 (use threadId()). */
    public long currentThreadId() {
        return Thread.currentThread().getId();
    }
}
