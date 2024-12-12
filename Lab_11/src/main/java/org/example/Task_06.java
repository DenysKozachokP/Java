package org.example;

import java.sql.*;
import java.math.BigDecimal;

public class Task_06 {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Підключення до бази даних успішне!");

            ProductDAO productDAO = new ProductDAO(connection);

            Product newProduct = new Product(0, "Product 1", BigDecimal.valueOf(29.99), 100, "Electronics", "Brand A");
            productDAO.create(newProduct);

            Product product = productDAO.read(1);
            if (product != null) {
                System.out.println("Отриманий товар: " + product);
            } else {
                System.out.println("Товар не знайдено.");
            }

            product.setPrice(BigDecimal.valueOf(34.99));
            productDAO.update(product);

            productDAO.delete(1);

            System.out.println("Всі товари в базі даних:");
            for (Product p : productDAO.getAll()) {
                System.out.println(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
