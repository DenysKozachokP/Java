package com.education.ztu;
import java.util.ArrayDeque;
import java.util.Deque;

public class Task_04 {
    public static void main(String[] args) {
        Deque<Product> productQueue = new ArrayDeque<>();
        productQueue.push(new Product("Laptop", 999.99, "Electronics",20,4));
        productQueue.offerLast(new Product("Coffee Maker", 49.99, "Appliances",90,99));

        System.out.println("First: " + productQueue.getFirst());
        System.out.println("Last: " + productQueue.peekLast());

        productQueue.pop();
        System.out.println("Queue: " + productQueue);
        productQueue.removeLast();
        System.out.println("Queue: " + productQueue);
    }
}
