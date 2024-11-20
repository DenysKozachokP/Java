package game;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant & Cloneable>{
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }


    public Team(Team<T> otherTeam) {
        this.name = otherTeam.name;
        this.participants = new ArrayList<>();
        for (T participant : otherTeam.participants) {
            try {
                this.participants.add((T) participant.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }


    public void addNewParticipant(T participant) {
        try {
            participants.add(participant);
            System.out.println("До команди " + name + " був доданий учасник " + participant.getName());
        }catch (Exception e){
            System.out.print("Неможливо додати учасника");
        }
    }

    public void playWith(Team<T> otherTeam) {
        if (otherTeam == null) {
            throw new IllegalArgumentException("Противник не може бути null");
        }

        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = otherTeam.name;
        }
        System.out.println("Команда " + winnerName + " перемогла!");
    }
    public void sortParticipantsByAge() {
        Collections.sort(participants, new AgeComparator());
    }

    public void sortParticipantsByNameAndAge() {
        Collections.sort(participants, new NameComparator());
    }

    public void printParticipants() {
        for (T participant : participants) {
            System.out.println(participant);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }
}
