package by.bsu.bakhar.dao;

import by.bsu.bakhar.entity.Product;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.rmi.Remote;
import java.util.List;

public interface ProductDao extends Remote {
    void addProduct(String name) throws IOException, JAXBException;

    void deleteProduct(String name) throws IOException, JAXBException;

    List<Product> getProducts() throws IOException, JAXBException;
}
