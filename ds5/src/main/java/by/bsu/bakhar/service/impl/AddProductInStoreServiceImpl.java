package by.bsu.bakhar.service.impl;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.service.AddProductInStoreService;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class AddProductInStoreServiceImpl implements AddProductInStoreService {

    @Override
    public void add(Store store, Product product, int amount) throws IOException, JAXBException {
        ProdInStoreDao prodInStoreDao = new ProdInStoreDaoImpl();
        if (prodInStoreDao.isPresent(store, product)) {
            prodInStoreDao.updateAmount(store, product, amount);
        } else {
            prodInStoreDao.addProdInStore(store, product, amount);
        }

    }
}
