package by.bsu.bakhar.dao.impl;

import by.bsu.bakhar.dao.StoreDao;
import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.xml_reader.CustomXMLReader;
import by.bsu.bakhar.xml_reader.impl.CustomStoreReader;
import by.bsu.bakhar.xml_writer.CustomXMLWriter;
import by.bsu.bakhar.xml_writer.impl.CustomStoreWriterImpl;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    private static final String xmlPath = "src/main/resources/data/stores.xml";
    private List<Store> storeList;

    public StoreDaoImpl() throws IOException, JAXBException {
        CustomXMLReader reader = new CustomStoreReader();
        storeList = reader.readFromXML(xmlPath);
    }

    @Override
    public List<Store> getStores() throws IOException, JAXBException {
        updateList();
        return storeList;
    }

    @Override
    public void addStore(String city) throws IOException, JAXBException {
        for (Store store : storeList) {
            if (store.getCity().equals(city)) {
                return;
            }
        }
        storeList.add(new Store(city.hashCode(), city));
        updateFile();
    }

    @Override
    public void deleteProduct(String city) throws IOException, JAXBException {
        for (Store store : storeList) {
            if (store.getCity().equals(city)) {
                storeList.remove(store);
            }
        }
        updateFile();
    }

    private void updateFile() throws IOException, JAXBException {
        CustomXMLWriter writer = new CustomStoreWriterImpl();
        writer.writeXML(storeList, xmlPath);
    }

    private void updateList() throws IOException, JAXBException {
        CustomXMLReader reader = new CustomStoreReader();
        storeList = reader.readFromXML(xmlPath);
    }
}
