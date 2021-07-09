package by.bakhar.project.dao;

import by.bakhar.project.entity.Entity;
import by.bakhar.project.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<T extends Entity> {
    protected Connection connection;

    public abstract List<T> findAll() throws DaoException;

    public abstract T findById(long id);

    public abstract boolean removeById(long id);

    public abstract boolean remove(T entity);

    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException troubles) {
                //log
            }
        }
    }

    void setConnection(Connection connection) {
        this.connection = connection;
    }
}
