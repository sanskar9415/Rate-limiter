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


OpenRewrite can fix these automatically (boring, repeated work with one clear answer):

Change the Java version in pom.xml (for example 8 to 17)
Replace old calls with their new versions, like new Integer(5) becoming Integer.valueOf(5)
Rename packages across all files (for example javax to jakarta)
Update library and plugin versions in the build file
Fix simple code patterns, like old-style loops or string handling

You must do these manually (they need a decision or have no simple replacement):

Removed Java features, like sun.misc.BASE64Encoder. You choose the replacement.
Hacky code, like reflection into Java's internal classes. It needs to be rewritten or deleted.
Missing libraries, like JAXB or Nashorn. You decide which one to add, or whether to drop the feature.
Broken tests. A tool can't know what a test is supposed to prove, so you update the test.
Code that compiles but behaves differently, like the Integer.valueOf cache. Only your tests and your own review catch this.
finalize() and other design changes, like switching to AutoCloseable.

Simple rule: if there's one obvious replacement, OpenRewrite does it. If someone has to choose or think, you do it.

Your workflow every time

Run OpenRewrite.
Read what it changed (git diff).
Run the tests.
Fix what's left by hand.


Step 5 (preview), try this:

./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:dryRunNoFork \
-Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-migrate-java:RELEASE \
-Drewrite.activeRecipes=org.openrewrite.java.migrate.UpgradeToJava17

Wait for BUILD SUCCESS, then look at the plan:

cat target/rewrite/rewrite.patch

Step 6 (apply), if the preview looks fine:

./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:runNoFork \
-Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-migrate-java:RELEASE \
-Drewrite.activeRecipes=org.openrewrite.java.migrate.UpgradeToJava17




export JAVA_HOME=$(/usr/libexec/java_home -v 17)
