
import game.Team;
import game.Participant;

public class Main2 {
    public static void main(String[] args) {
        Team<Participant> team = new Team<>("Команда A");
        team.addNewParticipant(new Participant("Олексій", 25) {});
        team.addNewParticipant(new Participant("Сергій", 30) {});
        team.addNewParticipant(new Participant("Ольга", 22) {});
        team.addNewParticipant(new Participant("Анна", 25) {});

        System.out.println("Учасники до сортування:");
        team.printParticipants();

        team.sortParticipantsByAge();
        System.out.println("\nУчасники після сортування за віком:");
        team.printParticipants();

        team.sortParticipantsByNameAndAge();
        System.out.println("\nУчасники після сортування за іменем :");
        team.printParticipants();
    }
}
