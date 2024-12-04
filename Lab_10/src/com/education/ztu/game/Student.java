package com.education.ztu.game;

import java.io.Serializable;

public class Student extends Participant implements Serializable {
    private static final long serialVersionUID = 1L;

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Student{name='" + getName() + "', age=" + getAge() + "}";
    }
}
