package by.bsu.bakhar.service.impl;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.json_writer.CustomJsonWriter;
import by.bsu.bakhar.json_writer.impl.ProdInStoreWriterImpl;
import by.bsu.bakhar.service.AddProductInStoreService;

import java.io.IOException;
import java.util.List;

public class AddProductInStoreServiceImpl implements AddProductInStoreService {
    private static final String jsonPath = "src/main/resources/data/lab1_prod_in_store.json";

    @Override
    public void add(Store store, Product product, int amount) throws IOException {
        ProdInStoreDao prodInStoreDao = new ProdInStoreDaoImpl();
        if (prodInStoreDao.isPresent(store, product)) {
            prodInStoreDao.updateAmount(store, product, amount);
        } else {
            prodInStoreDao.addProdInStore(store, product, amount);
        }

    }
}
