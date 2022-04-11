package by.bsu.bakhar.main;

import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.service.AddProductInStoreService;
import by.bsu.bakhar.service.CountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getProducts();
        System.out.println(productList);
        StoreDao storeDao = new StoreDao();
        List<Store> storeList = storeDao.getStores();
        System.out.println(storeList);
        CountService countService = new CountService();
        Optional<Integer> amount = countService.countAmountOfProduct(productList.get(0));
        amount.ifPresent(System.out::println);
        AddProductInStoreService addProductInStoreService = new AddProductInStoreService();
        addProductInStoreService.add(storeList.get(0), productList.get(0), 16);
        System.out.println(storeList.get(1));
        System.out.println(productList.get(0));
        addProductInStoreService.add(storeList.get(1), productList.get(0), 20);
        productDao.deleteProduct("iPhone");
    }
}
