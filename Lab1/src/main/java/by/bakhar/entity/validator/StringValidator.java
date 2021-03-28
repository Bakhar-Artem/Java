package by.bakhar.entity.validator;

public class StringValidator {
    public boolean IsValid(String string) {
        String[] values = string.split(",");
        try {
            for (String value : values) {
                Double.parseDouble(value);
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
