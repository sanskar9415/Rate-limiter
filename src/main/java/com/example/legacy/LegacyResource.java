package com.example.legacy;

/** finalize() is deprecated (for removal since Java 18). */
public class LegacyResource {

    private boolean closed;

    public void close() {
        closed = true;
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
