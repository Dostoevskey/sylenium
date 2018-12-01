package io.symonk.sylenium.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Dictates if a test should create its own unique test log and attach it to the report
 * default is true and attach is also true
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigureLog {
    
  boolean splitLogFiles() default true; // Should sylenium append all invocations of the same test to the same log file? or should it be unique per execution
  boolean keepOnlyFailure() default true; // Destroy log files if the test passes by default
  String  name() default ""; // By default sylenium will take the test name, override it if you desire for a test
  

}
