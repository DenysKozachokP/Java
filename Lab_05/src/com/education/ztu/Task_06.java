package com.education.ztu;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Task_06 {
    public static void main(String[] args) {
        Map<String, Product> productMap = new HashMap<>();

        productMap.put("Laptop", new Product("Laptop", 999.99, "Electronics", 3, 15));
        productMap.put("Coffee Maker", new Product("Coffee Maker", 49.99, "Appliances", 10, 3));
        productMap.put("Headphones", new Product("Headphones", 19.99, "Electronics", 7, 7));

        System.out.println("Get 'Laptop': " + productMap.get("Laptop"));

        System.out.println("Contains key 'Coffee Maker': " + productMap.containsKey("Coffee Maker"));

        System.out.println("Contains value 'Headphones': " + productMap.containsValue(new Product("Headphones", 19.99, "Electronics", 7, 7)));

        productMap.putIfAbsent("Book", new Product("Book", 100.0, "Books", 10, 10));
        System.out.println("Map after putIfAbsent: " + productMap);

        System.out.println("Key Set: " + productMap.keySet());

        System.out.println("Values: " + productMap.values());

        System.out.println("Size: " + productMap.size());

        productMap.remove("Coffee Maker");
        System.out.println("Map after remove: " + productMap);

        Map<String, Product> additionalProducts = new HashMap<>();
        additionalProducts.put("Tablet", new Product("Tablet", 299.99, "Electronics", 5, 5));
        productMap.putAll(additionalProducts);
        System.out.println("Map after putAll: " + productMap);

        productMap.clear();
        System.out.println("Map after clear: " + productMap);

        productMap.put("Laptop", new Product("Laptop", 999.99, "Electronics", 3, 15));
        productMap.put("Book", new Product("Book", 100.0, "Books", 10, 10));

        Set<Map.Entry<String, Product>> entrySet = productMap.entrySet();
        System.out.println("Entry Set:");

        for (Map.Entry<String, Product> entry : entrySet) {
            String key = entry.getKey();
            Product value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);

            if (key.equals("Laptop")) {
                entry.setValue(new Product("Laptop Pro", 1299.99, "Electronics", 2, 16));
            }
        }

        System.out.println("Map after modifying entrySet: " + productMap);
    }
}
