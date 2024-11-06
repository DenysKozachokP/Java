package com.education.ztu;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.DayOfWeek;
import java.time.Month;

public class Task_06 {
    public static void main(String[] args) {
        LocalDateTime labStart = LocalDateTime.of(2024, 11, 5, 13, 30, 0);

        System.out.println("День тижня: " + labStart.getDayOfWeek());
        System.out.println("День у році: " + labStart.getDayOfYear());
        System.out.println("Місяць: " + labStart.getMonth());
        System.out.println("Рік: " + labStart.getYear());
        System.out.println("Години: " + labStart.getHour());
        System.out.println("Хвилини: " + labStart.getMinute());
        System.out.println("Секунди: " + labStart.getSecond());

        Year year = Year.of(labStart.getYear());
        System.out.println("Рік високосний: " + year.isLeap());

        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nПоточна дата і час: " + now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        System.out.println("Лабораторна розпочалась раніше поточного часу: " + labStart.isBefore(now));
        System.out.println("Лабораторна розпочалась пізніше поточного часу: " + labStart.isAfter(now));

        LocalDateTime updatedLabStart = labStart.withYear(2025)
                .withMonth(12)
                .withDayOfMonth(25)
                .withHour(9)
                .withMinute(15)
                .withSecond(30);

        System.out.println("\nОновлена дата і час лабораторної: " + updatedLabStart.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }
}
