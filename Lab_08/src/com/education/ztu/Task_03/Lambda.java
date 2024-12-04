package com.education.ztu.Task_03;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("( A )#######################################################");
        System.out.println("");

        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        Predicate<String> notEmpty = str -> !str.isEmpty();
        Predicate<String> validNumber = isNumeric.and(notEmpty);

        System.out.println(validNumber.test("123.45"));  // true
        System.out.println(validNumber.test("abc"));     // false
        System.out.println(validNumber.test(""));        // false

        System.out.println("");
        System.out.println("( B )#######################################################");
        System.out.println("");

        Consumer<String> startLecture = msg -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endLecture = msg -> System.out.println("Пара закінчилася о 9:50");

        startLecture.andThen(endLecture).accept("");

        System.out.println("");
        System.out.println("( C )#######################################################");
        System.out.println("");

        Supplier<String> upperCaseMessage = () -> "Це приклад речення".toUpperCase();

        System.out.println(upperCaseMessage.get());

        System.out.println("");
        System.out.println("( D )#######################################################");
        System.out.println("");

        Function<String, Integer> productOfNumbers = str -> Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);

         String numbers = "2 3 4";
        System.out.println(productOfNumbers.apply(numbers));
    }
}
