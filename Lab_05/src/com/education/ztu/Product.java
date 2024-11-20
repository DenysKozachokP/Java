package com.education.ztu;
import java.util.*;

class Product {
    private String name;
    private double price;
    private String category;
    private int quantity;
    private int id;

    public Product(String name, double price, String category, int quantity, int id) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.id = id;
    }

    // Добавляем геттеры
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    // Переопределяем методы equals и hashCode для корректной работы с методами indexOf и sort
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category, quantity, id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }
}