package by.bsu.bakhar.xml_writer.impl;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.wrapper.ProdInStoreWrapper;
import by.bsu.bakhar.xml_writer.CustomXMLWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomProdInStoreWriterImpl implements CustomXMLWriter<ProdInStore> {
    @Override
    public void writeXML(List<ProdInStore> list, String xmlPath) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProdInStoreWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileWriter file = new FileWriter(xmlPath);
        ProdInStoreWrapper productWrapper = new ProdInStoreWrapper();
        productWrapper.setProdInStoreList(list);
        marshaller.marshal(productWrapper, file);
        file.close();
    }
}
