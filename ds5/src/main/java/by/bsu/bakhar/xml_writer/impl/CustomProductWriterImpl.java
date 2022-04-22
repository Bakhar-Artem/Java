package by.bsu.bakhar.xml_writer.impl;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.wrapper.ProductWrapper;
import by.bsu.bakhar.xml_writer.CustomXMLWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomProductWriterImpl implements CustomXMLWriter<Product> {
    @Override
    public void writeXML(List<Product> list, String xmlPath) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProductWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileWriter file = new FileWriter(xmlPath);
        ProductWrapper productWrapper = new ProductWrapper();
        productWrapper.setProducts(list);
        marshaller.marshal(productWrapper, file);
        file.close();
    }
}
