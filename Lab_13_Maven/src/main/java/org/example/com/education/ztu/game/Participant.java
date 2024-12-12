package org.example.com.education.ztu.game;

import java.util.Objects;

public abstract class Participant implements Cloneable {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Перевизначення методу clone для глибокого копіювання
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Перевизначення toString, equals, та hashCode
    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
