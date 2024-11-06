package com.education.ztu;
import java.util.TreeSet;

public class Task_05 {
    public static void main(String[] args) {
        TreeSet<Product> productSet = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        productSet.add(new Product("Laptop", 999.99, "Electronics",90,2));
        productSet.add(new Product("Coffee Maker", 49.99, "Appliances",34,15));

        System.out.println("First Product: " + productSet.first());
        System.out.println("Subset of Products: " + productSet.headSet(new Product("Laptop", 0, "",0,0)));
    }
}
