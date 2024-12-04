package com.education.ztu.Task_04;
import java.lang.reflect.Method;

public class Main4 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = AnnotatedClass.class;
            Method method = clazz.getMethod("myMethod");
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("Автор: " + annotation.author());
                System.out.println("Версія: " + annotation.version());
            }
            method.invoke(new AnnotatedClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
