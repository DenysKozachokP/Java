package com.education.ztu.game.Task_06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONParserDemo {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Participant participant = new Participant("John Doe", 30);

        String json = gson.toJson(participant);
        System.out.println("JSON представлення об'єкта:");
        System.out.println(json);

        try (FileWriter writer = new FileWriter("participant.json")) {
            gson.toJson(participant, writer);
            System.out.println("JSON збережено у файл participant.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("participant.json")) {
            Participant deserializedParticipant = gson.fromJson(reader, Participant.class);
            System.out.println("Десеріалізований об'єкт з JSON:");
            System.out.println(deserializedParticipant);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
