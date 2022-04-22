package by.bsu.bakhar.service.impl;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.service.CountService;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class CountServiceImpl implements CountService {
    @Override
    public Integer countAmountOfProduct(Product product) throws IOException, JAXBException {
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
