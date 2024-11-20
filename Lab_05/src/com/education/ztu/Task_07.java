package com.education.ztu;
import java.util.*;

public class Task_07 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));

        System.out.println("Original list: " + numbers);
        Collections.sort(numbers);
        System.out.println("Sorted list: " + numbers);

        int index = Collections.binarySearch(numbers, 40);
        System.out.println("Index of 40: " + index);

        Collections.reverse(numbers);
        System.out.println("Reversed list: " + numbers);

        Collections.fill(numbers, 99);
        System.out.println("List after fill: " + numbers);

        numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));

        int max = Collections.max(numbers);
        System.out.println("Max value: " + max);

        int min = Collections.min(numbers);
        System.out.println("Min value: " + min);

        List<Integer> copyList = new ArrayList<>(Arrays.asList(new Integer[numbers.size()])); // створюємо пустий список потрібного розміру
        Collections.copy(copyList, numbers);
        System.out.println("Copy of list: " + copyList);


        Collection<Integer> safeList = Collections.checkedCollection(new ArrayList<>(numbers), Integer.class);
        System.out.println("Checked collection: " + safeList);

        int freq = Collections.frequency(numbers, 10);
        System.out.println("Frequency of 10: " + freq);
    }
}
