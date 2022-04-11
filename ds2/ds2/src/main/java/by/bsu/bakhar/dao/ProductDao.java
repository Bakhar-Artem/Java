package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.pool.CustomPool;
import by.bsu.bakhar.pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String SQL_ADD_PRODUCT = "INSERT INTO product (NAME) VALUES(?);";
    private static final String SQL_DELETE_PRODUCT = "DELETE FROM product p WHERE p.name=?;";
    private static final String SQL_GET_ALL_PRODUCTS = "SELECT idproduct, name FROM product";
    private ProxyConnection connection;

    public ProductDao() {
        connection = CustomPool.INSTANCE.getConnection();
    }


    public void addProduct(String name) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_ADD_PRODUCT);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(String name) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCT);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_PRODUCTS);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                products.add(new Product(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

