package com.education.ztu;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість елементів у послідовності Фібоначчі: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Кількість елементів має бути додатною!");
        } else {
            int[] fibonacciArray = new int[n];
            fillFibonacci(fibonacciArray);
            System.out.println("Масив Фібоначчі:");
            printArray(fibonacciArray);
            System.out.println("Зворотній масив Фібоначчі:");
            printArray(reverseArray(fibonacciArray));
        }
        scanner.close();
    }
    public static void fillFibonacci(int[] array) {
        if (array.length > 0) array[0] = 1;
        if (array.length > 1) array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
    }
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
