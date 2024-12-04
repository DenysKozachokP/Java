package com.education.ztu.game;

import java.io.Serializable;

public class Schoolar extends Participant implements Serializable {
    private static final long serialVersionUID = 1L;

    public Schoolar(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Scholar{name='" + getName() + "', age=" + getAge() + "}";
    }
}

