package by.bsu.bakhar.dao.impl;


import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.pool.CustomPool;
import by.bsu.bakhar.pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    private static final String SQL_GET_STORES = "SELECT idstore, city_name FROM store INNER JOIN city ON store.idcity=city.idcity;";
    private static final String SQL_ADD_STORE = "INSERT INTO store (idcity) VALUES(?);";
    private static final String SQL_DELETE_STORE = "DELETE FROM store s WHERE s.idstore=?;";
    private ProxyConnection connection;

    public StoreDaoImpl() {
        this.connection = CustomPool.INSTANCE.getConnection();
    }

    @Override
    public List<Store> getStores() {
        List<Store> storeList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_GET_STORES);
            while (resultSet.next()) {
                storeList.add(new Store(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storeList;
    }

    @Override
    public void addStore(int id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_ADD_STORE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_STORE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
