package by.bakhar.project.dao;

import by.bakhar.project.entity.Entity;
import by.bakhar.project.exception.DaoException;
import by.bakhar.project.pool.ProxyConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<T extends Entity> {
    protected ProxyConnection connection;

    public abstract List<T> findAll() throws DaoException, SQLException;

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
    public abstract boolean addEntity(T entity) throws DaoException, SQLException;

    void setConnection(Connection connection) throws DaoException {
        if(connection.getClass()!= ProxyConnection.class){
            throw new DaoException("wrong connection class");
            //log
        }
        this.connection = (ProxyConnection) connection;
        }
}
