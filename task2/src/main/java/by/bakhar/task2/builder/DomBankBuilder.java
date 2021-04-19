package by.bakhar.task2.builder;

import by.bakhar.task2.entity.Bank;
import by.bakhar.task2.entity.DepositType;
import by.bakhar.task2.entity.TraditionalBank;
import by.bakhar.task2.entity.VirtualBank;
import by.bakhar.task2.exception.BankException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Year;

public class DomBankBuilder extends BankBuilder {
    private static Logger logger = LogManager.getLogger();
    private DocumentBuilder builder;

    public DomBankBuilder() throws BankException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("parsing is impossible");
            throw new BankException("parsing is impossible");
        }
    }


    @Override
    public void buildBanks(String xmlPath) throws BankException {
        Document document;

        try {
            document = builder.parse(xmlPath);
            Element root = document.getDocumentElement();

            String virtualBank = BankXmlTag.VIRTUAL_BANK.toString();
            String traditionalBank = BankXmlTag.TRADITIONAL_BANK.toString();
            NodeList virtualBanks = root.getElementsByTagName(virtualBank);
            NodeList traditionalBanks = root.getElementsByTagName(traditionalBank);

            for (int i = 0; i < virtualBanks.getLength(); i++) {
                Element element = (Element) virtualBanks.item(i);
                Bank bank = new VirtualBank();
                buildVirtualBank(element, bank);
                banks.add(bank);
            }

            for (int i = 0; i < traditionalBanks.getLength(); i++) {
                Element element = (Element) traditionalBanks.item(i);
                Bank bank = new TraditionalBank();
                buildTraditionalBank(element, bank);
                banks.add(bank);
            }
        } catch (SAXException e) {
            logger.error("Impossible to parse xml " + xmlPath);
            throw new BankException("Impossible to parse XML file (" + xmlPath + ")", e);
        } catch (IOException e) {
            logger.error("Impossible to open xml " + xmlPath);
            throw new BankException("Impossible to open xml " + xmlPath, e);
        } catch (NumberFormatException e) {
            logger.error("wrong data ");
            throw new BankException("Wrong data " + xmlPath);
        }
        logger.info("DOM parsing was success! " + xmlPath);
    }

    private void buildBank(Element element, Bank bank) {
        bank.setId(element.getAttribute("id"));
        DepositType depositType;
        String type = element.getAttribute("type");
        switch (type) {
            case "on-demand" -> depositType = DepositType.ONDEMAND;
            case "urgent" -> depositType = DepositType.URGENT;
            case "calculated" -> depositType = DepositType.CALCULATED;
            case "cumulative" -> depositType = DepositType.CUMULATIVE;
            default -> depositType = DepositType.SAVING;

        }
        bank.setDepositType(depositType);
        bank.setName(getElementTextContent(element, "name"));
        bank.setCountry(getElementTextContent(element, "country"));
        bank.setDepositor(getElementTextContent(element, "depositor"));
        bank.setTimeConstraint(Year.parse(getElementTextContent(element, "time-constraints")));
        bank.setProfitability(Integer.parseInt(getElementTextContent(element, "profitability")));
        bank.setAmountOnDeposit(Double.valueOf(getElementTextContent(element, "amount-on-deposit")));
    }

    private String getElementTextContent(Element element, String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Node node = nodeList.item(0);

        return node.getTextContent();
    }

    private void buildVirtualBank(Element element, Bank bank) {
        buildBank(element, bank);
        ((VirtualBank) bank).setWebsite(getElementTextContent(element, "website"));
    }

    private void buildTraditionalBank(Element element, Bank bank) {
        buildBank(element, bank);
        ((TraditionalBank) bank).setCountOfBranch(Integer.parseInt(getElementTextContent(element, "count-of-branch")));
    }
}
