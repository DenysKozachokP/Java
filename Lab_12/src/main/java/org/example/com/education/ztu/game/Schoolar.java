package org.example.com.education.ztu.game;

public class Schoolar extends Participant {
    public Schoolar(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Scholar{name='" + getName() + "', age=" + getAge() + "}";
    }
}

