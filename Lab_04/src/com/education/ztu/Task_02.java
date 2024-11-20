package com.education.ztu;

public class Task_02 {
    public static void main(String[] args) {
        String str = "I learn Java!!!";
        processString(str);
    }

    public static void processString(String str) {
        System.out.println("Останній символ рядка: " + str.charAt(str.length() - 1));

        System.out.println("'!!!': " + str.endsWith("!!!"));

        System.out.println("Чи починається рядок на 'I learn ': " + str.startsWith("I learn "));

        System.out.println("Чи містить рядок 'Java': " + str.contains("Java"));

        System.out.println("Позиція 'Java' у рядку: " + str.indexOf("Java"));

        String replacedString = str.replace('a', 'o');
        System.out.println("Рядок після заміни 'a' на 'o': " + replacedString);

        String upperCaseString = str.toUpperCase();
        System.out.println("Рядок у верхньому регістрі: " + upperCaseString);

        String lowerCaseString = str.toLowerCase();
        System.out.println("Рядок у нижньому регістрі: " + lowerCaseString);

        String cutString = str.replace("Java", "");
        System.out.println("Рядок після вирізання 'Java': " + cutString);
    }
}
