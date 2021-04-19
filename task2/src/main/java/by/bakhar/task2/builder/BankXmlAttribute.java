package by.bakhar.task2.builder;

public enum BankXmlAttribute {
    ID,
    TYPE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
