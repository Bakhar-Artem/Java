package by.bakhar.task3.validation;

public class ConeStringValidator {
    private static final String DOUBLE_REGEX = "([+-]?\\d+((\\.\\d+)|\\.)?\\s){6}(-)?\\d+((\\.\\d+)|\\.)?";

    public static boolean isStringValid(String data) {
        boolean valid = data.matches(DOUBLE_REGEX);
        return valid;
    }
}
