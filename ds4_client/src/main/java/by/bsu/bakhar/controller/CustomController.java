package by.bsu.bakhar.controller;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.service.AddProductInStoreService;
import by.bsu.bakhar.service.CountService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class CustomController {
    private static final String UNIQUE_NAME_PROD_IN_STORE = "prodInStoreDao";
    private static final String UNIQUE_NAME_PRODUCT = "productDao";
    private static final String UNIQUE_NAME_STORE = "storeDao";
    private static final String UNIQUE_NAME_ADD = "addProductInStoreService";
    private static final String UNIQUE_NAME_COUNT = "countService";
    final Registry registry = LocateRegistry.getRegistry("localhost",4545);
    private final ProdInStoreDao prodInStoreDao = (ProdInStoreDao) registry.lookup(UNIQUE_NAME_PROD_IN_STORE);
    private final ProductDao productDao = (ProductDao) registry.lookup(UNIQUE_NAME_PRODUCT);
    private final StoreDao storeDao = (StoreDao) registry.lookup(UNIQUE_NAME_STORE);
    private final AddProductInStoreService addProductInStoreService = (AddProductInStoreService) registry.lookup(UNIQUE_NAME_ADD);
    private final CountService countService = (CountService) registry.lookup(UNIQUE_NAME_COUNT);

    //start product tab
    @FXML
    private ListView productListView;
    @FXML
    private Button loadProductsButton;
    @FXML
    private TextField productName;
    @FXML
    private ComboBox productComboBox;
    //finish product tab

    //start store tab
    @FXML
    private Label prodInCountLabel;
    @FXML
    private ComboBox storeComboBox;
    @FXML
    private ComboBox productComboBoxStore;
    @FXML
    private ListView prodInStoreListView;
    @FXML
    private ComboBox storeComboBox1;
    @FXML
    private ComboBox productComboBoxStore1;
    @FXML
    private TextField prodInStoreValue;

    public CustomController() throws NotBoundException, RemoteException {
    }

    //finish store tab
    @FXML
    private void loadProducts(ActionEvent actionEvent) throws RemoteException {
        List<Product> productList = productDao.getProducts();
        ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
        productListView.setItems(observableList);
    }

    @FXML
    private void addProduct(ActionEvent actionEvent) throws RemoteException {
        String name = productName.getText();
        if (!name.isBlank()) {
            productDao.addProduct(name);
            loadProducts(null);
        }

    }

    @FXML
    private void fillProductComboBox(MouseEvent mouseEvent) throws RemoteException {
        List<Product> productList = productDao.getProducts();
        ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
        productComboBox.setItems(observableList);
        productComboBoxStore.setItems(observableList);
        productComboBoxStore1.setItems(observableList);
    }

    @FXML
    private void deleteProduct(ActionEvent actionEvent) throws RemoteException {
        Product productToDelete = (Product) productComboBox.getValue();
        if (productToDelete != null) {
            productDao.deleteProduct(productToDelete.getName());
            loadProducts(null);
        }


    }


    //start store tab
    @FXML
    private void fillStoreComboBox(MouseEvent mouseEvent) throws RemoteException {
        List<Store> storeList = storeDao.getStores();
        ObservableList<Store> observableList = FXCollections.observableArrayList(storeList);
        storeComboBox.setItems(observableList);
        storeComboBox1.setItems(observableList);
    }

    @FXML
    private void countProdInStores(ActionEvent actionEvent) throws RemoteException {
        Product productToCount = (Product) productComboBoxStore.getValue();
        if (productToCount != null) {
            Integer amount = countService.countAmountOfProduct(productToCount);
            prodInCountLabel.setText(amount.toString());
            prodInCountLabel.setVisible(true);
        }

    }

    @FXML
    private void fillProdInStore(ActionEvent actionEvent) throws RemoteException {
        Store store = (Store) storeComboBox.getValue();
        if (store != null) {
            List<ProdInStore> prods = prodInStoreDao.getProdInStore(store);
            ObservableList<ProdInStore> prodInStores = FXCollections.observableArrayList(prods);
            prodInStoreListView.setItems(prodInStores);
        }

    }

    @FXML
    private void updateProdInStore(ActionEvent actionEvent) throws RemoteException {
        Product product = (Product) productComboBoxStore1.getValue();
        Store store = (Store) storeComboBox1.getValue();
        if (product != null && store != null) {
            Integer amount;
            try {
                amount = Integer.parseInt(prodInStoreValue.getText());
            } catch (NumberFormatException numberFormatException) {
                return;
            }
            addProductInStoreService.add(store, product, amount);
            fillProdInStore(null);
        }


    }
}
