package by.bakhar.task2.builder;

public enum BankXmlTag {
    BANKS,
    TRADITIONAL_BANK,
    VIRTUAL_BANK,
    NAME,
    COUNTRY,
    DEPOSITOR,
    AMOUNT_ON_DEPOSIT,
    PROFITABILITY,
    TIME_CONSTRAINTS,
    WEBSITE,
    COUNT_OF_BRANCH;

    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';

    @Override
    public String toString() {
        return name()
                .toLowerCase()
                .replace(UNDERSCORE, HYPHEN);
    }

}
