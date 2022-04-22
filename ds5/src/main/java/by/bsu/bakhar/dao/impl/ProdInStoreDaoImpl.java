package by.bsu.bakhar.dao.impl;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.xml_reader.CustomXMLReader;
import by.bsu.bakhar.xml_reader.impl.CustomProdInStoreReader;
import by.bsu.bakhar.xml_writer.CustomXMLWriter;
import by.bsu.bakhar.xml_writer.impl.CustomProdInStoreWriterImpl;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProdInStoreDaoImpl implements ProdInStoreDao {
    private static final String xmlPath = "src/main/resources/data/prod_in_store.xml";
    private List<ProdInStore> prodInStoreList;

    public ProdInStoreDaoImpl() throws IOException, JAXBException {
        CustomXMLReader reader = new CustomProdInStoreReader();
        prodInStoreList = reader.readFromXML(xmlPath);
    }

    @Override
    public boolean isPresent(Store store, Product product) throws IOException, JAXBException {
        updateList();
        for (ProdInStore prodInStore : prodInStoreList) {
            if (prodInStore.getProduct().equals(product) && prodInStore.getStore().equals(store)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void addProdInStore(Store store, Product product, int amount) throws IOException, JAXBException {
        prodInStoreList.add(new ProdInStore(product, store, amount));
        updateFile();

    }

    @Override
    public void updateAmount(Store store, Product product, int amount) throws IOException, JAXBException {
        removeProdInStore(product, store);
        prodInStoreList.add(new ProdInStore(product, store, amount));
        updateFile();

    }

    @Override
    public List<ProdInStore> getProdInStore(Store store) throws IOException, JAXBException {
        List<ProdInStore> list = new CopyOnWriteArrayList<>();
        updateList();
        prodInStoreList.stream().filter(prInSt -> prInSt.getStore().equals(store)).forEach(list::add);

        return list;
    }


    @Override
    public void removeProdInStore(Product product, Store store) throws IOException, JAXBException {
        for (ProdInStore prodInStore : prodInStoreList) {
            if (prodInStore.getProduct().equals(product) && prodInStore.getStore().equals(store)) {
                prodInStoreList.remove(prodInStore);
            }
        }

        updateFile();
    }

    @Override
    public List<ProdInStore> getProdInStore() throws IOException, JAXBException {
        updateList();
        return prodInStoreList;
    }

    private void updateFile() throws IOException, JAXBException {
        CustomXMLWriter writer = new CustomProdInStoreWriterImpl();
        writer.writeXML(prodInStoreList, xmlPath);
    }

    private void updateList() throws IOException, JAXBException {
        CustomXMLReader reader = new CustomProdInStoreReader();
        prodInStoreList = reader.readFromXML(xmlPath);
    }
}
