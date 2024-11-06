package com.education.ztu;
import java.util.HashMap;
import java.util.Map;

public class Task_06 {
    public static void main(String[] args) {
        Map<String, Product> productMap = new HashMap<>();
        productMap.put("Laptop", new Product("Laptop", 999.99, "Electronics",10,10));
        productMap.putIfAbsent("Coffee Maker", new Product("Coffee Maker", 49.99, "Appliances",20,40));

        System.out.println("Product by name: " + productMap.get("Laptop"));
        System.out.println("Contains Key 'Laptop': " + productMap.containsKey("Laptop"));

        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
