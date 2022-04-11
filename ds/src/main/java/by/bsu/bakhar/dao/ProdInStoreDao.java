package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.pool.CustomPool;
import by.bsu.bakhar.pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProdInStoreDao {
    private static final String SQL_GET_PRODUCT_AMOUNT_FROM_ALL_STORES = "SELECT p.name, SUM(ps.amount) FROM product p INNER JOIN prod_in_store ps ON p.idproduct=?;";
    private static final String SQL_ADD_PROD_IN_STORE = "INSERT INTO prod_in_store (idstore,idproduct,amount) VAlUES(?,?,?);";
    private static final String SQL_UPDATE_AMOUNT = "UPDATE prod_in_store SET amount=? WHERE idproduct=? AND idstore=?;";
    private static final String SQL_GET_PROD_IN_STORE_AMOUNT = "SELECT ps.amount FROM product p INNER JOIN prod_in_store ps ON p.idproduct=ps.idproduct INNER JOIN store s ON ps.idstore=s.idstore WHERE p.idproduct=? AND s.idstore=?;";
    private ProxyConnection connection;

    public ProdInStoreDao() {
        connection = CustomPool.INSTANCE.getConnection();
    }

    public boolean isPresent(Store store, Product product) {
        PreparedStatement preparedStatement;
        boolean isPresent = false;
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_PROD_IN_STORE_AMOUNT);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setInt(2, store.getStoreId());
            ResultSet resultSet = preparedStatement.executeQuery();
            isPresent = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isPresent;
    }

    public Optional<Integer> getProductAmount(Product product) {
        PreparedStatement preparedStatement;
        Optional<Integer> amount = Optional.empty();
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_PRODUCT_AMOUNT_FROM_ALL_STORES);
            preparedStatement.setInt(1, product.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                amount = Optional.of(resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public void addProdInStore(Store store, Product product, int amount) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_ADD_PROD_IN_STORE);
            preparedStatement.setInt(2, product.getId());
            preparedStatement.setInt(1, store.getStoreId());
            preparedStatement.setInt(3, amount);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAmount(Store store, Product product, int amount) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_AMOUNT);
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, product.getId());
            preparedStatement.setInt(3, store.getStoreId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
