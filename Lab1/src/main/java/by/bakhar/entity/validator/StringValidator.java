package by.bakhar.entity.validator;

public class StringValidator {
    private final String DOUBLEHEADER = "^(\\d+([.])?+(\\d)?+[,]+\\b)*+\\d+([.]?)+\\d?";

    public boolean isValid(String string) {
        if (string.matches(DOUBLEHEADER)) {
            return true;
        } else {
            return false;
        }
    }
}
