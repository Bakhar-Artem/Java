package by.bsu.bakhar.xml_writer.impl;

import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.wrapper.StoreWrapper;
import by.bsu.bakhar.xml_writer.CustomXMLWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomStoreWriterImpl implements CustomXMLWriter<Store> {


    @Override
    public void writeXML(List<Store> list, String xmlPath) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(StoreWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileWriter file = new FileWriter(xmlPath);
        StoreWrapper storeWrapper = new StoreWrapper();
        storeWrapper.setStoreList(list);
        marshaller.marshal(storeWrapper,file);
        file.close();
    }
}
