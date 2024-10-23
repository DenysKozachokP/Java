import com.education.ztu.Student;
import com.education.ztu.Teacher;
import com.education.ztu.Employee;
import com.education.ztu.Car;
import com.education.ztu.Person;
import com.education.ztu.Gender;
import com.education.ztu.Location;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Олег", "Кравчук", 20, Gender.MALE, Location.KIEV, "3", "Комп'ютерні науки", "Київський університет");
        Teacher teacher = new Teacher("Іван", "Сидоренко", 45, Gender.MALE, Location.ZHYTOMYR, "Математика", "Житомирський університет", new Car("Honda"));
        Employee employee = new Employee("Анна", "Петрівна", 35, Gender.FEMALE, Location.VINNYTSYA, "Менеджер", "Google", new Car("Audi"));

        student.getOccupation();
        student.getFullInfo();

        teacher.getOccupation();
        teacher.getFullInfo();
        teacher.showCounter();

        employee.getOccupation();
        employee.getFullInfo();

        if (student instanceof Person) {
            System.out.println("student є екземпляром Person.");
        }

    }
}