package by.bakhar.task2.builder;

import by.bakhar.task2.exception.BankException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankBuilderFactory {
    private static Logger logger = LogManager.getLogger();

    private BankBuilderFactory() {
    }

    public static BankBuilder createBankBuilder(String parseType) throws BankException {
        try {
            ParseType parserType = ParseType.valueOf(parseType.toUpperCase());
            BankBuilder bankBuilder;
            switch (parserType) {
                case DOM -> bankBuilder = new DomBankBuilder();
                case SAX -> bankBuilder = new SaxBankBuilder();
                case STAX -> bankBuilder = new StaxBankBuilder();
                default -> throw new IllegalStateException("Unexpected value: " + parserType);
            }
            return bankBuilder;
        } catch (IllegalArgumentException e) {
            logger.error("Parser with name " + parseType + " is impossible ", e);
            throw new BankException("Parser with name " + parseType + " is impossible", e);
        }
    }
}
