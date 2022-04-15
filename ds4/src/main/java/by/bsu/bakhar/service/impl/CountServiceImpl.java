package by.bsu.bakhar.service.impl;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import by.bsu.bakhar.json_reader.impl.ProdInStoreReaderCustom;
import by.bsu.bakhar.service.CountService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

public class CountServiceImpl implements CountService {
    @Override
    public Integer countAmountOfProduct(Product product) throws IOException {
        Integer amount = 0;
        ProdInStoreDao prodInStoreDao = new ProdInStoreDaoImpl();
        for (ProdInStore prodInStore : prodInStoreDao.getProdInStore()) {
            if (prodInStore.getProduct().equals(product)) {
                amount += prodInStore.getAmount();
            }
        }
        return amount;
    }

}
