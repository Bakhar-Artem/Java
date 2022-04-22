package by.bsu.bakhar.service;

import by.bsu.bakhar.entity.Product;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.rmi.Remote;

public interface CountService extends Remote {
    Integer countAmountOfProduct(Product product) throws IOException, JAXBException;
}
