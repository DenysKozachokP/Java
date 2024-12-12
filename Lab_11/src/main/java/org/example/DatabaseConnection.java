package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {

    private static Connection connection;

    static {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
            String url = resourceBundle.getString("db.url");
            String username = resourceBundle.getString("db.username");
            String password = resourceBundle.getString("db.password");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Успешное подключение к базе данных!");

        } catch (SQLException e) {
            System.err.println("Не удалось подключиться к базе данных.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
