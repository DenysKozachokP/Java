package com.education.ztu.game.Task_06;


import java.io.Serializable;

/**
 * Клас, що представляє учасника гри.
 */
public class Participant implements Serializable {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }
}
