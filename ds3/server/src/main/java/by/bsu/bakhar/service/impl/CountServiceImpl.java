package by.bsu.bakhar.service.impl;


import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.service.CountService;

import java.util.Optional;

public class CountServiceImpl implements CountService {
    @Override
    public Integer countAmountOfProduct(Product product) {
        ProdInStoreDaoImpl prodInStoreDaoImpl = new ProdInStoreDaoImpl();
        Optional<Integer> amount = prodInStoreDaoImpl.getProductAmount(product);
        int result;
        if (amount.isPresent()) {
            result = amount.get();
        } else {
            result = 0;
        }
        return result;
    }
}
