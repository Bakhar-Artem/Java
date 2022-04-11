package by.bsu.bakhar.service;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;

import java.util.Optional;

public class AddProductInStoreService {
    public void add(Store store, Product product, int amount) {
        ProdInStoreDao prodInStoreDao = new ProdInStoreDao();
        if (prodInStoreDao.isPresent(store, product)) {
            prodInStoreDao.updateAmount(store, product, amount);
        } else {
            prodInStoreDao.addProdInStore(store, product, amount);
        }
    }
}
