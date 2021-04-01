package test.by.bakhar.entity.validator;

import by.bakhar.entity.validator.StringValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringValidatorTest {
    private StringValidator stringValidator = new StringValidator();

    @Test
    public void testIsValid() {
        String toCheck = "15.4, 78.2, 25.4, 0, 1d";
        boolean actual = stringValidator.isValid(toCheck);
        Assert.assertTrue(actual);
    }
}