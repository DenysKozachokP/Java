package com.education.ztu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task_03 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", 999.99, "Electronics", 3, 15));
        productList.add(new Product("Coffee Maker", 49.99, "Appliances", 10, 3));

        productList.addAll(List.of(new Product("Headphones", 19.99, "Electronics", 7, 7),
                new Product("Book", 100, "Books", 10, 10)));

        productList.get(1);
        System.out.println("Index of Laptop: " + productList.indexOf(new Product("Laptop", 999.99, "Electronics", 10, 1)));
        productList.remove(1);

        Collections.sort(productList, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Sorted Products: " + productList);
    }
}
