package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.rmi.Remote;
import java.util.List;

public interface ProdInStoreDao extends Remote {

    boolean isPresent(Store store, Product product) throws IOException, JAXBException;


    void addProdInStore(Store store, Product product, int amount) throws IOException, JAXBException;

    void updateAmount(Store store, Product product, int amount) throws IOException, JAXBException;

    List<ProdInStore> getProdInStore(Store store) throws IOException, JAXBException;

    void removeProdInStore(Product product, Store store) throws IOException, JAXBException;

    List<ProdInStore> getProdInStore() throws IOException, JAXBException;
}
