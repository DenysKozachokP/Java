package com.education.ztu.game;
import java.io.Serializable;

public class Employee extends Participant implements Serializable {
    private static final long serialVersionUID = 1L;

    public Employee(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Employee{name='" + getName() + "', age=" + getAge() + "}";
    }
}