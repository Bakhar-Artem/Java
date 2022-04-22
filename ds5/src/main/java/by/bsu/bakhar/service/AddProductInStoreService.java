package by.bsu.bakhar.service;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.rmi.Remote;

public interface AddProductInStoreService extends Remote {
    void add(Store store, Product product, int amount) throws IOException, JAXBException;
}
