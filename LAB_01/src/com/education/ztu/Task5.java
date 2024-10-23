package com.education.ztu;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ціле позитивне число: ");
        int number = scanner.nextInt(); // Зчитуємо число

        if (number < 0) {
            System.out.println("Число має бути позитивним!");
        } else {
            int sum = sumOfDigits(number);
            System.out.println("Сума цифр числа: " + sum);
        }
        scanner.close();
    }
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}



