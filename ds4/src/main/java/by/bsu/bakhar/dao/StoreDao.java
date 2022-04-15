package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Store;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StoreDao extends Remote {
    List<Store> getStores() throws IOException;

    void addStore(String city) throws IOException;

    void deleteProduct(String city) throws IOException;
}
