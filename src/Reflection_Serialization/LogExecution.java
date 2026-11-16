package Reflection_Serialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. @Retention(RUNTIME): Keeps this annotation alive at runtime so Reflection can read it
@Retention(RetentionPolicy.RUNTIME)

// 2. @Target(METHOD): Restricts this annotation to be placed ONLY above methods
@Target(ElementType.METHOD)
public @interface LogExecution {

    // Annotation elements look like methods; 'default' makes providing a value optional
    String tag() default "GENERAL";
    int priority() default 1;
}