package org.example;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {

    public ProductDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Product product) throws SQLException {
        String sql = "INSERT INTO Products (name, price, quantity, category, brand) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setBigDecimal(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getCategory());
            stmt.setString(5, product.getBrand());
            stmt.executeUpdate();
            System.out.println("Товар " + product.getName() + " додано.");
        }
    }

    @Override
    public Product read(int id) throws SQLException {
        String sql = "SELECT * FROM Products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToProduct(resultSet);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) throws SQLException {
        String sql = "UPDATE Products SET name = ?, price = ?, quantity = ?, category = ?, brand = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setBigDecimal(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getCategory());
            stmt.setString(5, product.getBrand());
            stmt.setInt(6, product.getId());
            stmt.executeUpdate();
            System.out.println("Товар " + product.getName() + " оновлено.");
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Товар з id = " + id + " видалено.");
        }
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                products.add(mapResultSetToProduct(resultSet));
            }
        }
        return products;
    }

    private Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        int quantity = resultSet.getInt("quantity");
        String category = resultSet.getString("category");
        String brand = resultSet.getString("brand");
        return new Product(id, name, price, quantity, category, brand);
    }
}