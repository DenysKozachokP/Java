package org.example;

import java.math.BigDecimal;
import java.sql.*;

public class Task_03 {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Підключення до бази даних успішне!");

            DataBaseCRUD.createTable(connection);

            DataBaseCRUD.addProducts(connection,10);

            DataBaseCRUD.fetchData(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}