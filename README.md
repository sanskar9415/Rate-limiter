# Java 8 -> 17 migration practice

Copy src/ into your Spring Boot 2.7.x project (java.version = 1.8).
Change the package name if yours differs.

1. JDK 8:  mvn clean test      -> 13 tests pass (note the count)
2. JDK 17: mvn clean test      -> see what breaks, fix each one

| Class                 | Problem on 17                                  | Fix idea                                              |
|-----------------------|------------------------------------------------|-------------------------------------------------------|
| LegacyEncoder         | sun.misc.BASE64* removed -> compile error      | java.util.Base64                                      |
| LegacyXmlService      | javax.xml.bind removed (JDK 11)                | jakarta.xml.bind-api + org.glassfish.jaxb:jaxb-runtime 2.3.x |
| LegacyReflection      | InaccessibleObjectException                    | delete the hack; rewrite test to assert something sane|
| LegacyScriptService   | Nashorn removed (JDK 15) -> NPE                | org.openjdk.nashorn:nashorn-core, or drop JS eval     |
| LegacyBoxing          | deprecated-for-removal warnings                | Integer.valueOf, Boolean.parseBoolean                 |
| LegacyFactory         | Class.newInstance deprecated                   | getDeclaredConstructor().newInstance()                |
| LegacyResource        | finalize deprecated for removal                | AutoCloseable / try-with-resources                    |
| LegacyDateService     | Date ctor/getYear, Thread.getId deprecated     | java.time, Thread.threadId() (19+)                    |

Tip: compile with -Xlint:deprecation,removal to see every warning.
