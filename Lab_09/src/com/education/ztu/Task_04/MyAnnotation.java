package com.education.ztu.Task_04;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String author() default "Anonymous";
    int version() default 1;
}
