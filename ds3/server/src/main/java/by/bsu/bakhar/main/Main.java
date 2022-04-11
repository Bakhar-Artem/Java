package by.bsu.bakhar.main;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.dao.impl.ProdInStoreDaoImpl;
import by.bsu.bakhar.dao.impl.ProductDaoImpl;
import by.bsu.bakhar.dao.impl.StoreDaoImpl;
import by.bsu.bakhar.service.AddProductInStoreService;
import by.bsu.bakhar.service.CountService;
import by.bsu.bakhar.service.impl.AddProductInStoreServiceImpl;
import by.bsu.bakhar.service.impl.CountServiceImpl;

import javax.management.remote.rmi.RMIJRMPServerImpl;
import javax.management.remote.rmi.RMIServer;
import java.io.IOException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    private static final String UNIQUE_NAME_PROD_IN_STORE = "prodInStoreDao";
    private static final String UNIQUE_NAME_PRODUCT = "productDao";
    private static final String UNIQUE_NAME_STORE = "storeDao";
    private static final String UNIQUE_NAME_ADD = "addProductInStoreService";
    private static final String UNIQUE_NAME_COUNT = "countService";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
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


        System.out.println("Server is ready");
    }
}
