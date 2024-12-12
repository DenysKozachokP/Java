package org.example;

import java.math.BigDecimal;
import java.sql.*;

public class DataBaseCRUD {
    public static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Products (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "price DECIMAL(10, 2), " +
                "quantity INT, " +
                "category VARCHAR(255), " +
                "brand VARCHAR(255))";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Таблиця створена або вже існує.");
        }
    }
    public static void addProducts(Connection connection, int quantity) throws SQLException {
        String insertSQL = "INSERT INTO Products (name, price, quantity, category, brand) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            connection.setAutoCommit(false);

            for (int i = 1; i <= quantity; i++) {
                preparedStatement.setString(1, "Product " + i);
                preparedStatement.setBigDecimal(2, BigDecimal.valueOf(10.99 + i));
                preparedStatement.setInt(3, 100 + i);
                preparedStatement.setString(4, "Electronics");
                preparedStatement.setString(5, "Brand A");
                preparedStatement.addBatch();
            }

            int[] affectedRecords = preparedStatement.executeBatch();
            connection.commit();
            System.out.println(affectedRecords.length + " записів додано в таблицю.");
        }
    }

    public static void fetchData(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM Products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");
                String brand = resultSet.getString("brand");
                System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d, Category: %s, Brand: %s%n",
                        id, name, price, quantity, category, brand);
            }
        }
    }

    public static void fetchDataByCategory(Connection connection, String category) throws SQLException {
        String selectSQL = "SELECT * FROM Products WHERE category = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, category);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Товари в категорії: " + category);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    BigDecimal price = resultSet.getBigDecimal("price");
                    int quantity = resultSet.getInt("quantity");
                    String productCategory = resultSet.getString("category");
                    String brand = resultSet.getString("brand");
                    System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d, Category: %s, Brand: %s%n",
                            id, name, price, quantity, productCategory, brand);
                }
            }
        }
    }
    public static void deleteAllData(Connection connection) throws SQLException {
        String deleteSQL = "DELETE FROM Products";
        try (Statement statement = connection.createStatement()) {
            int rowsDeleted = statement.executeUpdate(deleteSQL);
            System.out.println(rowsDeleted + " записів видалено з таблиці.");
        }
    }public static void addProduct(Connection connection, String name, double price, int quantity, String category, String brand) throws SQLException {
        String insertSQL = "INSERT INTO Products (name, price, quantity, category, brand) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setBigDecimal(2, BigDecimal.valueOf(price));
            preparedStatement.setInt(3, quantity);
            preparedStatement.setString(4, category);
            preparedStatement.setString(5, brand);
            preparedStatement.executeUpdate();
            System.out.println("Товар " + name + " додано успішно.");
        }
    }
    public static void addProductWithSyntaxError(Connection connection, String name, double price, int quantity, String category, String brand) throws SQLException {
        String insertSQL = "INSERT INTO Products (name, price, quantity, category, brand) VALUES (?, ?, ?, ?)";
        // Пропускаємо значення для одного з параметрів, що викличе помилку
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setBigDecimal(2, BigDecimal.valueOf(price));
            preparedStatement.setInt(3, quantity);
            preparedStatement.setString(4, brand);
            preparedStatement.executeUpdate();
            System.out.println("Товар " + name + " додано успішно.");
        }
    }
}
