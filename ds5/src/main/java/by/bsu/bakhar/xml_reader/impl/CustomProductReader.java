package by.bsu.bakhar.xml_reader.impl;

import by.bsu.bakhar.wrapper.ProductWrapper;
import by.bsu.bakhar.xml_reader.CustomXMLReader;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomProductReader implements CustomXMLReader {
    @Override
    public List readFromXML(String xmlPath) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProductWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        FileReader fileReader = new FileReader(xmlPath);
        ProductWrapper productWrapper = (ProductWrapper) unmarshaller.unmarshal(fileReader);
        fileReader.close();
        return new CopyOnWriteArrayList(productWrapper.getProducts());
    }
}
