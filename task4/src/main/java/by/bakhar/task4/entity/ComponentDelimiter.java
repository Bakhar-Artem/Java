package by.bakhar.task4.entity;

public enum ComponentDelimiter {
    SPACE("\s"),
    TAB("\t"),
    ENTER("\n");
    private String delimiter;

    private ComponentDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String toString() {
        return delimiter;
    }
}
