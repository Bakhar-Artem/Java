package by.bakhar.task2.builder;

import by.bakhar.task2.exception.BankException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxBankBuilder extends BankBuilder {
    private static Logger logger = LogManager.getLogger(SaxBankBuilder.class);
    private BankHandler handler;
    private XMLReader reader;

    public SaxBankBuilder() throws BankException {
        handler = new BankHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException | ParserConfigurationException e) {
            logger.error("sax parsing is impossible");
            throw new BankException("sax parsing is impossible", e);
        }
    }


    @Override
    public void buildBanks(String xmlPath) throws BankException {
        try {
            reader.parse(xmlPath);
        } catch (SAXException e) {
            logger.error("Impossible to parse xml " + xmlPath);
            throw new BankException("Impossible to parse XML file (" + xmlPath + ")", e);
        } catch (IOException e) {
            logger.error("Impossible to open xml " + xmlPath);
            throw new BankException("Impossible to open xml " + xmlPath, e);
        } catch (NumberFormatException e) {
            logger.error("wrong data");
            throw new BankException("wrong data");
        }
        banks = handler.getBanks();
        logger.info("sax parsing was success!");
    }
}
