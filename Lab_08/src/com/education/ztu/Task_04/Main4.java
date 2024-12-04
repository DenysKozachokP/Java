package com.education.ztu.Task_04;

import java.util.*;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        Product[] products = {
                new Product("Laptop", "BrandA", 1200, 5),
                new Product("Smartphone", "BrandB", 800, 10),
                new Product("Tablet", "BrandA", 600, 7),
                new Product("Monitor", "BrandC", 300, 4),
                new Product("Keyboard", "BrandB", 50, 15)
        };

        System.out.println("Усі бренди:");
        Arrays.stream(products)
                .map(product -> product.brand)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nТовари з ціною менше 1000:");
        Arrays.stream(products)
                .filter(product -> product.price < 1000)
                .limit(2)
                .forEach(System.out::println);

        int totalCount = Arrays.stream(products)
                .map(product -> product.count)
                .reduce(0, Integer::sum);
        System.out.println("\nЗагальна кількість товарів на складі: " + totalCount);

        System.out.println("\nТовари, згруповані за брендом:");
        Map<String, List<Product>> groupedByBrand = Arrays.stream(products)
                .collect(Collectors.groupingBy(product -> product.brand));
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println("Бренд: " + brand);
            productList.forEach(System.out::println);
        });

        System.out.println("\nТовари, відсортовані за ціною:");
        List<Product> sortedByPrice = Arrays.stream(products)
                .sorted(Comparator.comparingDouble(product -> product.price))
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println);
    }
}
