package com.education.ztu.game;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;


/**
 * Клас, що представляє команду учасників.
 * @param <T> Тип учасників, який успадковує {@link Participant} та {@link Cloneable}.
 */
public class Team<T extends Participant & Cloneable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<T> participants = new ArrayList<>();

    /**
     * Конструктор для створення команди з заданим ім'ям.
     * @param name Назва команди.
     */
    public Team(String name) {
        this.name = name;
    }

    /**
     * Додає нового учасника до команди.
     * @param participant Учасник, що додається.
     */
    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("До команди " + name + " був доданий учасник " + participant.getName());
    }

    /**
     * Запускає гру між двома командами.
     * @param otherTeam Інша команда-суперник.
     * @throws IllegalArgumentException якщо команда-суперник є null.
     */
    public void playWith(Team<T> otherTeam) {
        if (otherTeam == null) {
            throw new IllegalArgumentException("Противник не може бути null");
        }

        String winnerName = Math.random() < 0.5 ? this.name : otherTeam.name;
        System.out.println("Команда " + winnerName + " перемогла!");
    }

    /**
     * Виводить список учасників команди.
     */
    public void printParticipants() {
        for (T participant : participants) {
            System.out.println(participant);
        }
    }

    // Геттери та сеттери

    /**
     * Отримує назву команди.
     * @return Назва команди.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву команди.
     * @param name Нова назва команди.
     */
    public void setName(String name) {
        this.name = name;
    }
}

