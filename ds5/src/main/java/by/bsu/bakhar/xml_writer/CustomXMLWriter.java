package by.bsu.bakhar.xml_writer;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface CustomXMLWriter<T> {
    void writeXML(List<T> list, String xmlPath) throws IOException, JAXBException;
}
