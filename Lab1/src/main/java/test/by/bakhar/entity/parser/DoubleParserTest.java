package test.by.bakhar.entity.parser;

import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.parser.DoubleParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DoubleParserTest {
    private DoubleParser doubleParser = new DoubleParser();

    @Test
    public void testParseToDouble() throws DoubleArrayException {
        double[] expected = new double[]{15.4, 78.2, 25.4, 0, 2d};
        double[] actual=doubleParser.parseToDouble("15.4, 78.2, 25.4, 0, 2d");
        Assert.assertEquals(actual,expected);
    }
}