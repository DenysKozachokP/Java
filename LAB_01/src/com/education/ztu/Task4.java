package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше ціле додатнє число: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Введіть друге ціле додатнє число: ");
        int secondNumber = scanner.nextInt();
        int result = gcd(firstNumber, secondNumber);
        System.out.println("Найбільший спільний дільник: " + result);

    }
}