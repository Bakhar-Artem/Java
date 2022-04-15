package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Store;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StoreDao extends Remote {
    List<Store> getStores()throws RemoteException;

    void addStore(int id)throws RemoteException;

    void deleteProduct(int id)throws RemoteException;
}
