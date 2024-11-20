import game.Employee;
import game.Schoolar;
import game.Team;
import game.Student;

public class Main {
    public static void main(String[] args) {
        Team<Student> studentTeam1 = new Team<>("Студентська команда 1");
        Student student1 = new Student("Іван", 20);
        Student student2 = new Student("Олена", 22);

        studentTeam1.addNewParticipant(student1);
        studentTeam1.addNewParticipant(student2);

        Team<Student> scholarTeam1 = new Team<>("Шкільна команда 1");
        Student scholar1 = new Student("Ighor", 20);
        Student scholar2 = new Student("Sen", 22);

        studentTeam1.playWith(scholarTeam1);

        Team<Student> clonedTeam = new Team<>(studentTeam1);
        System.out.println("Оригінальна команда: " + studentTeam1);
        System.out.println("Клонована команда: " + clonedTeam);

        System.out.println("HashCode студента: " + student1.hashCode());

        System.out.println(student1);
        System.out.println(student2);

        studentTeam1.playWith(clonedTeam);
    }
}