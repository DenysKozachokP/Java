package org.example;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<T> {

    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    // Створення нового запису
    public abstract void create(T entity) throws SQLException;

    // Читання запису по id
    public abstract T read(int id) throws SQLException;

    // Оновлення запису
    public abstract void update(T entity) throws SQLException;

    // Видалення запису
    public abstract void delete(int id) throws SQLException;

    // Отримання всіх записів
    public abstract List<T> getAll() throws SQLException;
}
