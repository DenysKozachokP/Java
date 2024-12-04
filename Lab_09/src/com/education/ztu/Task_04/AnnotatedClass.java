package com.education.ztu.Task_04;

public class AnnotatedClass {
    @MyAnnotation(author = "Іван Іванович", version = 2)
    public void myMethod() {
        System.out.println("Це анотований метод.");
    }
}
