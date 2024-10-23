import com.education.ztu.Location;
import com.education.ztu.Operation;

public class Main_2 {
    public static void main(String[] args) {
        int sum = Operation.addition(5, 10, 15, 20);
        System.out.println("Сума: " + sum);

        int difference = Operation.subtraction(50, 10, 5);
        System.out.println("Різниця: " + difference);

        int product = Operation.multiplication(2, 3, 4);
        System.out.println("Добуток: " + product);

        float quotient = Operation.division(100, 5, 2);
        System.out.println("Частка: " + quotient);

        float average = Operation.average(10, 20, 30, 40);
        System.out.println("Середнє: " + average);

        int max = Operation.maximum(1, 20, 30, 5);
        System.out.println("Максимум: " + max);

        int min = Operation.minimum(1, 20, 30, 5);
        System.out.println("Мінімум: " + min);


        for (Location location : Location.values()) {
            System.out.println(location);
        }
    }
}
