package org.example;

import java.math.BigDecimal;
import java.sql.*;

public class Task_04 {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Підключення до бази даних успішне!");

            DataBaseCRUD.addProducts(connection,5);

            DataBaseCRUD.fetchDataByCategory(connection, "Electronics");

            DataBaseCRUD.deleteAllData(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
