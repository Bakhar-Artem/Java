package by.bakhar.task2.builder;

import by.bakhar.task2.entity.Bank;
import by.bakhar.task2.entity.DepositType;
import by.bakhar.task2.entity.TraditionalBank;
import by.bakhar.task2.entity.VirtualBank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Year;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class BankHandler extends DefaultHandler {
    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';
    private static Logger logger = LogManager.getLogger();
    private Set<Bank> banks;
    private EnumSet<BankXmlTag> tagsWithTextContent;
    private Bank currentBank;
    private BankXmlTag currentTag;

    public BankHandler() {
        banks = new HashSet<>();
        tagsWithTextContent=EnumSet.range(BankXmlTag.NAME,BankXmlTag.COUNT_OF_BRANCH);
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    static void fillTag(BankXmlTag currentTag, Bank currentBank, String data) {
        switch (currentTag) {
            case NAME -> currentBank.setName(data);
            case COUNTRY -> currentBank.setCountry(data);
            case TIME_CONSTRAINTS -> currentBank.setTimeConstraint(Year.parse(data));
            case DEPOSITOR -> currentBank.setDepositor(data);
            case PROFITABILITY -> currentBank.setProfitability(Integer.parseInt(data));
            case AMOUNT_ON_DEPOSIT -> currentBank.setAmountOnDeposit(Double.valueOf(data));
            case WEBSITE -> ((VirtualBank) currentBank).setWebsite(data);
            case COUNT_OF_BRANCH -> ((TraditionalBank) currentBank).setCountOfBranch(Integer.parseInt(data));
            default -> throw new EnumConstantNotPresentException(
                    currentTag.getDeclaringClass(), currentTag.name());
        }
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String VirtualBankTag = BankXmlTag.VIRTUAL_BANK.toString();
        String TraditionalBankTag = BankXmlTag.TRADITIONAL_BANK.toString();

        if (TraditionalBankTag.equals(qName) || VirtualBankTag.equals(qName)) {
            if (TraditionalBankTag.equals(qName)) {
                currentBank = new TraditionalBank();
            } else {
                currentBank = new VirtualBank();
            }
            String idAttribute = BankXmlAttribute.ID.toString();
            String typeAttribute = BankXmlAttribute.TYPE.toString();
            if (attributes.getLength() == 1) {
                String bankId = attributes.getValue(0);
                currentBank.setId(bankId);
                currentBank.setDepositType(DepositType.SAVING);
            } else {
                if (attributes.getQName(0).equals(idAttribute)) {
                    String bankId = attributes.getValue(0);
                    currentBank.setId(bankId);
                    String type = attributes.getValue(1);
                    setDepositType(type);
                } else {
                    String bankId = attributes.getValue(1);
                    currentBank.setId(bankId);
                    String type = attributes.getValue(0);
                    setDepositType(type);
                }
            }
        } else {
            BankXmlTag tag = BankXmlTag.valueOf(qName.toUpperCase().replace(HYPHEN, UNDERSCORE));
            if (tagsWithTextContent.contains(tag)) {
                currentTag = tag;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        String VirtualBankTag = BankXmlTag.VIRTUAL_BANK.toString();
        String TraditionalBankTag = BankXmlTag.TRADITIONAL_BANK.toString();

        if (VirtualBankTag.equals(qName) || TraditionalBankTag.equals(qName)) {
            banks.add(currentBank);
        }
    }

    private void setDepositType(String type) {
        switch (type) {
            case "on-demand" -> currentBank.setDepositType(DepositType.ONDEMAND);
            case "urgent" -> currentBank.setDepositType(DepositType.URGENT);
            case "calculated" -> currentBank.setDepositType(DepositType.CALCULATED);
            case "cumulative" -> currentBank.setDepositType(DepositType.CUMULATIVE);
            case "saving" -> currentBank.setDepositType(DepositType.SAVING);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);

        if (currentTag != null) {
            fillTag(currentTag, currentBank, data);
        }
        currentTag = null;
    }

}
