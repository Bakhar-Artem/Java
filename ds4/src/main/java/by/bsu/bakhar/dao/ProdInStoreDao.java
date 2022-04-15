package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface ProdInStoreDao extends Remote {

    boolean isPresent(Store store, Product product) throws IOException;


    void addProdInStore(Store store, Product product, int amount) throws IOException;

    void updateAmount(Store store, Product product, int amount) throws IOException;

    List<ProdInStore> getProdInStore(Store store) throws IOException;

    void cascadeDelete(Product product) throws IOException;

    void cascadeDelete(Store store) throws IOException;

    void removeProdInStore(Product product, Store store) throws IOException;

    List<ProdInStore> getProdInStore() throws IOException;
}
