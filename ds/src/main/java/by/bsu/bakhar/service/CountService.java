package by.bsu.bakhar.service;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.entity.Product;

import java.util.Optional;

public class CountService {
    public Optional<Integer> countAmountOfProduct(Product product) {
        ProdInStoreDao prodInStoreDao = new ProdInStoreDao();
        return prodInStoreDao.getProductAmount(product);
    }
}
