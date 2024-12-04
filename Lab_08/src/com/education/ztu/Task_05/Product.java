package com.education.ztu.Task_05;

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
    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}