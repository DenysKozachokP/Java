package com.education.ztu;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Task_05 {
    public static void main(String[] args) {

        Locale locale = new Locale( "en","US");
        //Locale locale = new Locale( "fr","FR");
        //Locale locale = new Locale( "uk","UA");
        //System.out.println(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("com.education.ztu.resources.data", locale);

        String[][] items = {
                {bundle.getString("product1"), bundle.getString("category1"), "1500.78"},
                {bundle.getString("product2"), bundle.getString("category1"), "1000.56"},
                {bundle.getString("product3"), bundle.getString("category2"), "500.78"},
        };

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", locale);
        String date = dateFormat.format(new Date());

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        StringBuilder receipt = new StringBuilder();
        receipt.append(bundle.getString("date")).append(": ").append(date).append("\n");
        receipt.append("===========================================\n");
        receipt.append(String.format("%-3s %-10s %-15s %s%n", bundle.getString("header").split(" ")[0],
                bundle.getString("header").split(" ")[1], bundle.getString("header").split(" ")[2],
                bundle.getString("header").split(" ")[3]));
        receipt.append("===========================================\n");

        double total = 0;
        for (int i = 0; i < items.length; i++) {
            String name = items[i][0];
            String category = items[i][1];
            double price = Double.parseDouble(items[i][2]);

            receipt.append(String.format("%-3d %-10s %-15s %10s%n", i + 1, name, category, currencyFormat.format(price)));
            total += price;
        }

        receipt.append("===========================================\n");
        receipt.append(String.format("%s: %30s%n", bundle.getString("total"), currencyFormat.format(total)));

        System.out.println(receipt.toString());
    }
}
