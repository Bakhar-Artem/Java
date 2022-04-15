package by.bsu.bakhar.dao.impl;

import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import by.bsu.bakhar.json_reader.impl.StoreReaderCustom;
import by.bsu.bakhar.json_writer.CustomJsonWriter;
import by.bsu.bakhar.json_writer.impl.StoreWriterImpl;

import java.io.IOException;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    private static final String jsonPath = "src/main/resources/data/lab1_store.json";
    private List<Store> storeList;

    public StoreDaoImpl() throws IOException {
        CustomJsonReader reader = new StoreReaderCustom();
        storeList = reader.readFromJson(jsonPath);
    }

    @Override
    public List<Store> getStores() throws IOException {
        updateList();
        return storeList;
    }

    @Override
    public void addStore(String city) throws IOException {
        for (Store store : storeList) {
            if (store.getCity().equals(city)) {
                return;
            }
        }
        storeList.add(new Store(city.hashCode(), city));
        updateFile();
    }

    @Override
    public void deleteProduct(String city) throws IOException {
        for (Store store : storeList) {
            if (store.getCity().equals(city)) {
                storeList.remove(store);
            }
        }
        updateFile();
    }

    private void updateFile() throws IOException {
        CustomJsonWriter writer = new StoreWriterImpl();
        writer.writeJson(storeList, jsonPath);
    }

    private void updateList() throws IOException {
        CustomJsonReader reader = new StoreReaderCustom();
        storeList = reader.readFromJson(jsonPath);
    }
}
