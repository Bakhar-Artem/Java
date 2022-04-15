package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Product;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductDao extends Remote {
    void addProduct(String name) throws IOException;

    void deleteProduct(String name) throws IOException;

    List<Product> getProducts() throws IOException;
}
