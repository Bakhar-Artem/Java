package by.bakhar.project.dao;

import by.bakhar.project.entity.Entity;
import by.bakhar.project.exception.DaoException;
import by.bakhar.project.pool.ProxyConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Entity> {
    protected ProxyConnection connection;

    public abstract List<T> findAll() throws DaoException;

    public abstract Optional<T> findById(long id)throws DaoException;

    public abstract boolean removeById(long id)throws DaoException;

    public abstract boolean remove(T entity)throws DaoException;

    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException troubles) {
                //log
            }
        }
    }

    void setConnection(Connection connection) throws DaoException {
        if(connection.getClass()!= ProxyConnection.class){
            throw new DaoException("wrong connection class");
            //log
        }
        this.connection = (ProxyConnection) connection;
        }
}
