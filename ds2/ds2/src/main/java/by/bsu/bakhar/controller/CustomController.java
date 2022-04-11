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

import java.util.List;
import java.util.Optional;

public class CustomController {

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

    //finish store tab
    @FXML
    private void loadProducts(ActionEvent actionEvent) {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getProducts();
        ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
        productListView.setItems(observableList);
    }

    @FXML
    private void addProduct(ActionEvent actionEvent) {
        String name = productName.getText();
        if (!name.isBlank()) {
            ProductDao productDao = new ProductDao();
            productDao.addProduct(name);
            loadProducts(null);
        }

    }

    @FXML
    private void fillProductComboBox(MouseEvent mouseEvent) {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getProducts();
        ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
        productComboBox.setItems(observableList);
        productComboBoxStore.setItems(observableList);
        productComboBoxStore1.setItems(observableList);
    }

    @FXML
    private void deleteProduct(ActionEvent actionEvent) {
        Product productToDelete = (Product) productComboBox.getValue();
        if (productToDelete != null) {
            ProductDao productDao = new ProductDao();
            productDao.deleteProduct(productToDelete.getName());
            loadProducts(null);
        }


    }


    //start store tab
    @FXML
    private void fillStoreComboBox(MouseEvent mouseEvent) {
        StoreDao storeDao = new StoreDao();
        List<Store> storeList = storeDao.getStores();
        ObservableList<Store> observableList = FXCollections.observableArrayList(storeList);
        storeComboBox.setItems(observableList);
        storeComboBox1.setItems(observableList);
    }

    @FXML
    private void countProdInStores(ActionEvent actionEvent) {
        Product productToCount = (Product) productComboBoxStore.getValue();
        if (productToCount != null) {
            CountService countService = new CountService();
            Optional<Integer> amount = countService.countAmountOfProduct(productToCount);
            if (amount.isPresent()) {
                prodInCountLabel.setText(amount.get().toString());
            } else {
                prodInCountLabel.setText("0");
            }
            prodInCountLabel.setVisible(true);
        }

    }

    @FXML
    private void fillProdInStore(ActionEvent actionEvent) {
        Store store = (Store) storeComboBox.getValue();
        if (store != null) {
            ProdInStoreDao prodInStoreDao = new ProdInStoreDao();
            List<ProdInStore> prods = prodInStoreDao.getProdInStore(store);
            ObservableList<ProdInStore> prodInStores = FXCollections.observableArrayList(prods);
            prodInStoreListView.setItems(prodInStores);
        }

    }

    @FXML
    private void updateProdInStore(ActionEvent actionEvent) {
        Product product = (Product) productComboBoxStore1.getValue();
        Store store = (Store) storeComboBox1.getValue();
        if (product != null && store != null) {
            Integer amount;
            try {
                amount = Integer.parseInt(prodInStoreValue.getText());
            } catch (NumberFormatException numberFormatException) {
                return;
            }
            AddProductInStoreService addProductInStoreService = new AddProductInStoreService();
            addProductInStoreService.add(store, product, amount);
        }


    }
}
