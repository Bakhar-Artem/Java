package by.bsu.bakhar.main;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.dao.impl.ProductDaoImpl;
import by.bsu.bakhar.dao.impl.StoreDaoImpl;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.service.AddProductInStoreService;
import by.bsu.bakhar.service.CountService;
import by.bsu.bakhar.service.impl.AddProductInStoreServiceImpl;
import by.bsu.bakhar.service.impl.CountServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Main {
    private static final String UNIQUE_NAME_PROD_IN_STORE = "prodInStoreDao";
    private static final String UNIQUE_NAME_PRODUCT = "productDao";
    private static final String UNIQUE_NAME_STORE = "storeDao";
    private static final String UNIQUE_NAME_ADD = "addProductInStoreService";
    private static final String UNIQUE_NAME_COUNT = "countService";

    public static void main(String[] args) throws IOException, AlreadyBoundException {
        final ProdInStoreDao prodInStoreDao = new ProdInStoreDaoImpl();
        final ProductDao productDao = new ProductDaoImpl();
        final StoreDao storeDao = new StoreDaoImpl();
        final AddProductInStoreService addProductInStoreService = new AddProductInStoreServiceImpl();
        final CountService countService = new CountServiceImpl();
        final Registry registry = LocateRegistry.createRegistry(4545);
        final ProdInStoreDao prodInStoreDaoStub = (ProdInStoreDao) UnicastRemoteObject.exportObject(prodInStoreDao, 0);
        final ProductDao productDaoStub = (ProductDao) UnicastRemoteObject.exportObject(productDao, 0);
        final StoreDao storeDaoStub = (StoreDao) UnicastRemoteObject.exportObject(storeDao, 0);
        final AddProductInStoreService addProductInStoreServiceStub = (AddProductInStoreService) UnicastRemoteObject.exportObject(addProductInStoreService, 0);
        final CountService countServiceStub = (CountService) UnicastRemoteObject.exportObject(countService, 0);
        registry.bind(UNIQUE_NAME_PROD_IN_STORE, prodInStoreDaoStub);
        registry.bind(UNIQUE_NAME_PRODUCT, productDaoStub);
        registry.bind(UNIQUE_NAME_STORE, storeDaoStub);
        registry.bind(UNIQUE_NAME_ADD, addProductInStoreServiceStub);
        registry.bind(UNIQUE_NAME_COUNT, countServiceStub);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FileReader reader = new FileReader("src/main/resources/data/lab1_product.json");
        List<Product> list = gson.fromJson(reader, new TypeToken<List<Product>>() {
        }.getType());
        reader.close();
        FileWriter fileWriter = new FileWriter("src/main/resources/data/lab1_product.json");
        gson.toJson(list, fileWriter);
        fileWriter.close();

    }
}
