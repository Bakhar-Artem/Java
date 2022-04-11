package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductDao extends Remote {
    void addProduct(String name)throws RemoteException;

    void deleteProduct(String name)throws RemoteException;

    List<Product> getProducts()throws RemoteException;
}
