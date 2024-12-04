package com.education.ztu.game;

import java.io.Serializable;
import java.util.Objects;

/**
 * Абстрактний клас, що представляє учасника гри.
 * Реалізує інтерфейси {@link Cloneable} та {@link Serializable}.
 */
public abstract class Participant implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int age; // Не серіалізується

    /**
     * Конструктор для створення учасника з іменем та віком.
     * @param name Ім'я учасника.
     * @param age Вік учасника.
     */
    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Клонування об'єкта для створення глибокої копії.
     * @return Клонований об'єкт {@link Participant}.
     * @throws CloneNotSupportedException якщо клонування не підтримується.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Повертає рядкове представлення об'єкта.
     * @return Рядок з інформацією про учасника.
     */
    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }

    // Геттери та сеттери з відповідною документацією

    /**
     * Отримує ім'я учасника.
     * @return Ім'я учасника.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює ім'я учасника.
     * @param name Нове ім'я учасника.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує вік учасника.
     * @return Вік учасника.
     */
    public int getAge() {
        return age;
    }

    /**
     * Встановлює вік учасника.
     * @param age Новий вік учасника.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
