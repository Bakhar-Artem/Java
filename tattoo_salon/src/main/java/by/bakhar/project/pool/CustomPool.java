package by.bakhar.project.pool;

import by.bakhar.project.exception.ProxyConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum CustomPool {
    INSTANCE;
    private BlockingQueue<ProxyConnection> freeConnection;
    private Queue<ProxyConnection> givenAwayConnection;

    private final static String DATABASE_URL = "jdbc:postgresql://localhost:3306/salon";
    private final static String DATABASE_USER = "postgres";
    private final static String DATABASE_PASS = "root";
    private final static int DEFAULT_POOL_SIZE = 32;

    CustomPool() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        freeConnection = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnection = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnection.offer(new ProxyConnection(DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS)));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnection.take();
            givenAwayConnection.offer(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws ProxyConnectionException {
        if (connection.getClass() != ProxyConnection.class) {
            throw new ProxyConnectionException();
        }
        givenAwayConnection.remove(connection);
        freeConnection.offer((ProxyConnection) connection);
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnection.take().reallyClose();
            } catch (SQLException exception) {
                exception.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException exception) {
                //log
            }
        });
    }
}
