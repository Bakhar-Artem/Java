package by.bsu.bakhar.dao.impl;

import by.bsu.bakhar.dao.ProdInStoreDao;
import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import by.bsu.bakhar.json_reader.impl.ProdInStoreReaderCustom;
import by.bsu.bakhar.json_writer.CustomJsonWriter;
import by.bsu.bakhar.json_writer.impl.ProdInStoreWriterImpl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProdInStoreDaoImpl implements ProdInStoreDao {
    private static final String jsonPath = "src/main/resources/data/lab1_prod_in_store.json";
    private List<ProdInStore> prodInStoreList;

    public ProdInStoreDaoImpl() throws IOException {
        CustomJsonReader reader = new ProdInStoreReaderCustom();
        prodInStoreList = reader.readFromJson(jsonPath);
    }

    @Override
    public boolean isPresent(Store store, Product product) throws IOException {
        updateList();
        for (ProdInStore prodInStore : prodInStoreList) {
            if (prodInStore.getProduct().equals(product) && prodInStore.getStore().equals(store)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void addProdInStore(Store store, Product product, int amount) throws IOException {
        prodInStoreList.add(new ProdInStore(product, store, amount));
        updateFile();

    }

    @Override
    public void updateAmount(Store store, Product product, int amount) throws IOException {
        removeProdInStore(product, store);
        prodInStoreList.add(new ProdInStore(product, store, amount));
        updateFile();

    }

    @Override
    public List<ProdInStore> getProdInStore(Store store) throws IOException {
        List<ProdInStore> list = new CopyOnWriteArrayList<>();
        updateList();
        prodInStoreList.stream().filter(prInSt -> prInSt.getStore().equals(store)).forEach(list::add);

        return list;
    }

    @Override
    public void cascadeDelete(Product product) throws IOException {
        for (ProdInStore prodInStore : prodInStoreList) {
            if (prodInStore.getProduct().equals(product)) {
                prodInStoreList.remove(prodInStore);
            }
        }
        updateFile();
    }

    @Override
    public void cascadeDelete(Store store) throws IOException {
        for (ProdInStore prodInStore : prodInStoreList) {
            if (prodInStore.getStore().equals(store)) {
                prodInStoreList.remove(prodInStore);
            }
        }
        updateFile();
    }

    @Override
    public void removeProdInStore(Product product, Store store) throws IOException {
        for (ProdInStore prodInStore : prodInStoreList) {
            if (prodInStore.getProduct().equals(product) && prodInStore.getStore().equals(store)) {
                prodInStoreList.remove(prodInStore);
            }
        }

        updateFile();
    }

    @Override
    public List<ProdInStore> getProdInStore() throws IOException {
        updateList();
        return prodInStoreList;
    }

    private void updateFile() throws IOException {
        CustomJsonWriter writer = new ProdInStoreWriterImpl();
        writer.writeJson(prodInStoreList, jsonPath);
    }

    private void updateList() throws IOException {
        CustomJsonReader reader = new ProdInStoreReaderCustom();
        prodInStoreList = reader.readFromJson(jsonPath);
    }
}
