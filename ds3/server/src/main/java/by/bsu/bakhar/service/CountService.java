package by.bsu.bakhar.service;

import by.bsu.bakhar.entity.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CountService extends Remote {
    Integer countAmountOfProduct(Product product) throws RemoteException;
}
