package com.sunflower.java;

import java.lang.annotation.*;

@Repeatable(MyAnnotations.class)
@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value() default {"00","99"};
    String[] value1();
}

@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations{
    MyAnnotation[] value();
}
