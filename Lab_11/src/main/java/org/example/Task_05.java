package org.example;

import java.math.BigDecimal;
import java.sql.*;

public class Task_05 {
    public static void main(String[] args) {

        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Підключення до бази даних успішне!");
            connection.setAutoCommit(false);
            DataBaseCRUD.addProduct(connection, "Product 1", 20.99, 100, "Electronics", "Brand A");
            Savepoint savepoint = connection.setSavepoint("FirstProductAdded");

            try {
                DataBaseCRUD.addProductWithSyntaxError(connection, "Product 2", 30.99, 50, "Electronics", "Brand B");
            } catch (SQLException e) {
                System.out.println("Помилка при додаванні другого товару: " + e.getMessage());
                connection.rollback(savepoint);
                System.out.println("Відкотили транзакцію до точки збереження.");
            }

            connection.commit();
            DataBaseCRUD.fetchData(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
