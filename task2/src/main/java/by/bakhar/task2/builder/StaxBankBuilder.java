package by.bakhar.task2.builder;

import by.bakhar.task2.entity.Bank;
import by.bakhar.task2.entity.DepositType;
import by.bakhar.task2.entity.TraditionalBank;
import by.bakhar.task2.entity.VirtualBank;
import by.bakhar.task2.exception.BankException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.Optional;

public class StaxBankBuilder extends BankBuilder {
    private static Logger logger = LogManager.getLogger(StaxBankBuilder.class);
    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';

    private static final String TRADITIONAL_BANK_TAG = BankXmlTag.TRADITIONAL_BANK.toString();
    private static final String VIRTUAL_BANK_TAG = BankXmlTag.VIRTUAL_BANK.toString();

    @Override
    public void buildBanks(String xmlPath) throws BankException {
        String name;

        try {
            Source source = new StreamSource(xmlPath);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(source);

            while (reader.hasNext()) {
                int type = reader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();

                    if (name.equals(TRADITIONAL_BANK_TAG)) {
                        Bank currentBank = new TraditionalBank();

                        buildBank(currentBank, reader);
                        banks.add(currentBank);
                    }

                    if (name.equals(VIRTUAL_BANK_TAG)) {
                        Bank bank = new VirtualBank();
                        buildBank(bank, reader);
                        banks.add(bank);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error("file reading error");
            throw new BankException("file reading error ", e);
        }
        logger.info("stax parsing was success!");
    }


    private void buildBank(Bank currentBank, XMLStreamReader reader) throws XMLStreamException, BankException {
        String id;
        String depositType = "";
        if (reader.getAttributeCount() == 1) {
            id = reader.getAttributeValue(null, BankXmlAttribute.ID.toString());
        } else {
            id = reader.getAttributeValue(null, BankXmlAttribute.ID.toString());
            depositType = reader.getAttributeValue(null, BankXmlAttribute.TYPE.toString());
        }
        currentBank.setId(id);
        switch (depositType) {
            case "on-demand" -> currentBank.setDepositType(DepositType.ONDEMAND);
            case "urgent" -> currentBank.setDepositType(DepositType.URGENT);
            case "calculated" -> currentBank.setDepositType(DepositType.CALCULATED);
            case "cumulative" -> currentBank.setDepositType(DepositType.CUMULATIVE);
            default -> currentBank.setDepositType(DepositType.SAVING);
        }
        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    String name = reader.getLocalName();
                    BankXmlTag currentTag = BankXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE));
                    try {
                        buildCurrentBank(reader, currentTag, currentBank);
                    } catch (NumberFormatException e) {
                        logger.error("wrong data!");
                        throw new BankException("wrong data", e);
                    }

                }
                case XMLStreamConstants.END_ELEMENT -> {
                    String name = reader.getLocalName();

                    if (name.equals(TRADITIONAL_BANK_TAG) || name.equals(VIRTUAL_BANK_TAG)) {
                        return;
                    }
                }
            }
        }

        throw new BankException("impossible to build Bank");
    }

    private void buildCurrentBank(XMLStreamReader reader, BankXmlTag currentTag, Bank currentBank)
            throws BankException, XMLStreamException {

        String data = getTextContent(reader).orElseThrow(() -> new BankException("impossible to get text content"));

        BankHandler.fillTag(currentTag, currentBank, data);
    }


    private Optional<String> getTextContent(XMLStreamReader reader) throws XMLStreamException {
        Optional<String> result = Optional.empty();

        if (reader.hasNext()) {
            reader.next();
            String text = reader.getText();
            result = Optional.of(text);
        }

        return result;
    }
}
