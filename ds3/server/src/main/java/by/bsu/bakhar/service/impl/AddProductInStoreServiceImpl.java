package by.bsu.bakhar.service.impl;


import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.service.AddProductInStoreService;

public class AddProductInStoreServiceImpl implements AddProductInStoreService {
    @Override
    public void add(Store store, Product product, int amount) {
        ProdInStoreDaoImpl prodInStoreDaoImpl = new ProdInStoreDaoImpl();
        if (prodInStoreDaoImpl.isPresent(store, product)) {
            prodInStoreDaoImpl.updateAmount(store, product, amount);
        } else {
            prodInStoreDaoImpl.addProdInStore(store, product, amount);
        }
    }
}
