package com.education.ztu.Task_06;

import java.util.Optional;
import java.util.Arrays;

public class Main6 {
    public static void main(String[] args) {
        Integer[] numbers = {10, 20, 30, 5, 70};
        Optional<Integer> maxNumber = Arrays.stream(numbers).max(Integer::compareTo);

        String result = maxNumber.map(String::valueOf).orElse("Числа відсутні");
        System.out.println("Максимальне значення: " + result);
    }
}
