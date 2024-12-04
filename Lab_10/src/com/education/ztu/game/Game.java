package com.education.ztu.game;
import java.io.*;

/**
 * Основний клас гри.
 */
public class Game {
    /**
     * Головний метод програми.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        // Створення команди
        Team<Employee> team = new Team<>("Team A");
        team.addNewParticipant(new Employee("John Doe", 30));

        // Серіалізація команди
        serializeTeam(team, "team.ser");

        // Десеріалізація команди
        Team<Employee> deserializedTeam = deserializeTeam("team.ser");
        if (deserializedTeam != null) {
            deserializedTeam.printParticipants();
        }
    }

    public static void serializeTeam(Team<?> team, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(team);
            System.out.println("Серіалізація завершена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Team<Employee> deserializeTeam(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Team<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}