package by.bsu.bakhar.dao.impl;

import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import by.bsu.bakhar.json_reader.impl.ProdInStoreReaderCustom;
import by.bsu.bakhar.json_reader.impl.ProductReaderCustom;
import by.bsu.bakhar.json_writer.CustomJsonWriter;
import by.bsu.bakhar.json_writer.impl.ProdInStoreWriterImpl;
import by.bsu.bakhar.json_writer.impl.ProductWriterImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String jsonPath = "src/main/resources/data/lab1_product.json";
    private List<Product> productList;

    public ProductDaoImpl() throws IOException {
        CustomJsonReader reader = new ProductReaderCustom();
        productList = reader.readFromJson(jsonPath);
    }

    @Override
    public void addProduct(String name) throws IOException {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return;
            }
        }
        productList.add(new Product(name.hashCode(), name));
        updateFile();
    }

    @Override
    public void deleteProduct(String name) throws IOException {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                productList.remove(product);
            }
        }

        updateFile();
    }

    @Override
    public List<Product> getProducts() throws IOException {
        updateList();
        return productList;
    }
    private void updateFile() throws IOException {
        CustomJsonWriter writer = new ProductWriterImpl();
        writer.writeJson(productList,jsonPath);
    }
    private void updateList() throws IOException {
        CustomJsonReader reader = new ProductReaderCustom();
        productList = reader.readFromJson(jsonPath);
    }
}
