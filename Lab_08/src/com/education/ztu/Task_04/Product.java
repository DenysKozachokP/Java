package com.education.ztu.Task_04;

class Product {
    String name;
    String brand;
    double price;
    int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', brand='%s', price=%.2f, count=%d}",
                name, brand, price, count);
    }
}