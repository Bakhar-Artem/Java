package by.bakhar.task3.validation;

public class ConeStringValidator {
    private final static String DOUBLE_REGEX = "^\\d+(\\.\\d+)?\\s+\\d+(\\.\\d+)?\\d+(\\.\\d+)?\\s+\\d+(\\.\\d+)?\\s+\\d+(\\.\\d+)?\\s+\\d+(\\.\\d+)?\\s+\\d+(\\.\\d+)?\\s+";

    public static boolean isStringValid(String data) {
        boolean valid = data.matches(DOUBLE_REGEX);
        return valid;
    }
}
