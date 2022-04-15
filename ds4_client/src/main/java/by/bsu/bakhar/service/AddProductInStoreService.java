package by.bsu.bakhar.service;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddProductInStoreService extends Remote {
    void add(Store store, Product product, int amount)throws RemoteException;
}
