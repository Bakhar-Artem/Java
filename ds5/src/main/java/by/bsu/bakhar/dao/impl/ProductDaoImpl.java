package by.bsu.bakhar.dao.impl;

import by.bsu.bakhar.dao.ProductDao;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.xml_reader.CustomXMLReader;
import by.bsu.bakhar.xml_reader.impl.CustomProductReader;
import by.bsu.bakhar.xml_writer.CustomXMLWriter;
import by.bsu.bakhar.xml_writer.impl.CustomProductWriterImpl;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String xmlPath = "src/main/resources/data/products.xml";
    private List<Product> productList;

    public ProductDaoImpl() throws IOException, JAXBException {
        CustomXMLReader reader = new CustomProductReader();
        productList = reader.readFromXML(xmlPath);
    }

    @Override
    public void addProduct(String name) throws IOException, JAXBException {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return;
            }
        }
        productList.add(new Product(name.hashCode(), name));
        updateFile();
    }

    @Override
    public void deleteProduct(String name) throws IOException, JAXBException {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                productList.remove(product);
            }
        }

        updateFile();
    }

    @Override
    public List<Product> getProducts() throws IOException, JAXBException {
        updateList();
        return productList;
    }

    private void updateFile() throws IOException, JAXBException {
        CustomXMLWriter writer = new CustomProductWriterImpl();
        writer.writeXML(productList, xmlPath);
    }

    private void updateList() throws IOException, JAXBException {
        CustomXMLReader reader = new CustomProductReader();
        productList = reader.readFromXML(xmlPath);
    }
}
