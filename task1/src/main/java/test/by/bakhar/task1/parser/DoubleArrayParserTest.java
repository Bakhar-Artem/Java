package test.by.bakhar.task1.parser;

import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.parser.DoubleArrayParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleArrayParserTest {
    private DoubleArrayParser doubleArrayParser = new DoubleArrayParser();

    @Test
    public void testParseToDouble() throws DoubleArrayException {
        double[] expected = new double[]{15.4, 78.2, 25.4, 0, 2d};
        double[] actual= doubleArrayParser.parseToDouble("15.4, 78.2, 25.4, 0, 2d");
        Assert.assertEquals(actual,expected);
    }
}