package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Store;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.rmi.Remote;
import java.util.List;

public interface StoreDao extends Remote {
    List<Store> getStores() throws IOException, JAXBException;

    void addStore(String city) throws IOException, JAXBException;

    void deleteProduct(String city) throws IOException, JAXBException;
}
