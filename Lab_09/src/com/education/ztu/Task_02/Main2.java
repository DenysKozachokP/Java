package com.education.ztu.Task_02;

import java.util.regex.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        String text = """
            1. Іванов Іван Іванович, вік: 30, посада: програміст, досвід: 5 років, дата народження: 20.05.1995, 
               адреса: Київ, email: ivanov@example.com, телефон: +380(67)123-45-67
            2. Петров Петро Петрович, вік: 40, посада: менеджер, досвід: 10 років, дата народження: 15.06.1983, 
               адреса: Харків, email: petrov@example.com, телефон: +380(50)987-65-43
            3. Сидорова Марія Олексіївна, вік: 28, посада: дизайнер, досвід: 3 роки, дата народження: 09.09.1994, 
               адреса: Одеса, email: sidorova@example.com, телефон: +380(93)456-78-90
            4. Коваленко Олег Сергійович, вік: 35, посада: тестувальник, досвід: 7 років, дата народження: 22.02.1988, 
               адреса: Львів, email: kovalenko@example.com, телефон: +380(44)234-56-78
            5. Лисенко Оксана Миколаївна, вік: 29, посада: HR-менеджер, досвід: 4 роки, дата народження: 01.01.1994, 
               адреса: Дніпро, email: lisenko@example.com, телефон: +380(96)345-67-89
            """;

        System.out.println("Номери телефонів:");
        Pattern phonePattern = Pattern.compile("\\+380\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        System.out.println("\nEmail-адреси:");
        Pattern emailPattern = Pattern.compile("\\b[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        System.out.println("\nТекст зі зміненим форматом дати народження:");
        String updatedText = text.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println(updatedText);

        System.out.println("\nТекст із оновленими посадами:");
        updatedText = updatedText.replaceFirst("програміст", "архітектор ПЗ")
                .replaceFirst("дизайнер", "UX-дизайнер");
        System.out.println(updatedText);
    }
}
