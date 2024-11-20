package com.education.ztu;
import java.util.*;

public class Task_03 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Laptop", 999.99, "Electronics", 3, 15));
        productList.add(new Product("Coffee Maker", 49.99, "Appliances", 10, 3));
        productList.addAll(List.of(
                new Product("Headphones", 19.99, "Electronics", 7, 7),
                new Product("Book", 100, "Books", 10, 10)
        ));

        System.out.println("list = " + productList);

        System.out.println("prod index 1 = " + productList.get(1));

        productList.remove(1);
        System.out.println("list after remove = " + productList);

        Collections.sort(productList, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Sorted Products: " + productList);

        System.out.println("Index of Headphones: " + productList.indexOf(new Product("Headphones", 19.99, "Electronics", 7, 7)));
        System.out.println("Is list empty - " + productList.isEmpty());
        System.out.println("Does list contain Laptop " + productList.contains(new Product("Laptop", 999.99, "Electronics", 3, 15)));
        System.out.println("List size: " + productList.size());


        List<Product> subList = productList.subList(0, productList.size());
        System.out.println("SubList: " + subList);

        Product[] productArray = productList.toArray(new Product[0]);
        System.out.println("Array from list: " + Arrays.toString(productArray));

        productList.clear();
        System.out.println("List after clear: " + productList);
    }
}
