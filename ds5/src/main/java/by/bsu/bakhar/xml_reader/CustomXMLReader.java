package by.bsu.bakhar.xml_reader;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface CustomXMLReader {
    List readFromXML(String xmlPath) throws IOException, JAXBException;
}
