package com.education.ztu;
import java.util.Formatter;

public class Task_04 {
    public static void main(String[] args) {
        String[][] items = {
                {"Джинси", "Жіночий одяг", "1500.78"},
                {"Спідниця", "Жіночий одяг", "1000.56"},
                {"Краватка", "Чоловічий одяг", "500.78"},
                {"Сорочка", "Чоловічий одяг", "750.45"},
                {"Пальто", "Жіночий одяг", "3500.00"},
                {"Футболка", "Чоловічий одяг", "299.99"},
                {"Куртка", "Жіночий одяг", "2000.00"},
                {"Сукня", "Жіночий одяг", "1800.50"},
                {"Шкарпетки", "Чоловічий одяг", "50.00"},
                {"Шорти", "Чоловічий одяг", "450.45"}
        };

        StringBuilder receipt = new StringBuilder();
        Formatter formatter = new Formatter(receipt);

        formatter.format("Дата та час покупки: %s%n", "28.03.2019 13:25:12");
        formatter.format("===========================================%n");
        formatter.format("%-3s %-10s %-15s %-10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================%n");

        double total = 0;
        for (int i = 0; i < items.length; i++) {
            String name = items[i][0];
            String category = items[i][1];
            double price = Double.parseDouble(items[i][2]);

            formatter.format("%-3d %-10s %-15s %10.2f ₴%n", i + 1, name, category, price);
            total += price;
        }

        formatter.format("===========================================%n");
        formatter.format("Разом: %31.2f ₴%n", total);

        System.out.println(receipt.toString());

        formatter.close();
    }
}
