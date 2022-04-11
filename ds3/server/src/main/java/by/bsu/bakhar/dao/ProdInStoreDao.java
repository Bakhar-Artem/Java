package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface ProdInStoreDao extends Remote{

    boolean isPresent(Store store, Product product) throws RemoteException;

    Optional<Integer> getProductAmount(Product product)throws RemoteException;

    void addProdInStore(Store store, Product product, int amount)throws RemoteException;

    void updateAmount(Store store, Product product, int amount)throws RemoteException;

    List<ProdInStore> getProdInStore(Store store)throws RemoteException;
}
