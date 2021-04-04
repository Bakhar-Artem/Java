package test.by.bakhar.task1.creator;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.creator.DoubleArrayCreator;
import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.exception.DoubleArrayReaderException;
import by.bakhar.task1.parser.DoubleArrayParser;
import by.bakhar.task1.reader.DoubleArrayReader;
import by.bakhar.task1.reader.impl.DoubleArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DoubleArrayReadAndCreateTest {
    private DoubleArrayReader reader = new DoubleArrayReaderImpl();
    private DoubleArrayCreator creator = new DoubleArrayCreator();
    private DoubleArrayParser parser = new DoubleArrayParser();
    private final static String FILEPATH = "src/main/resources/data/data.txt";

    @Test(description = "Read, parse, create")
    public void testReadAndCreate() throws DoubleArrayReaderException, DoubleArrayException {
        List<String> stringArrays = reader.readFromTxt(FILEPATH);
        List<double[]> doubleArrays = new ArrayList<>();
        for (String stringArray : stringArrays) {
            doubleArrays.add(parser.parseToDouble(stringArray));
        }
        List<DoubleArray> expected = new ArrayList<>();
        for (double[] doubleArray : doubleArrays) {
            expected.add(creator.create(doubleArray));
        }
        List<DoubleArray> actual = new ArrayList<>();
        actual.add(new DoubleArray(15.4, 78.2, 25.4, 0, 2d));
        actual.add(new DoubleArray(15.4, 78.2, 25.4, 2d));
        actual.add(new DoubleArray(0, 1, 35.4));
        Assert.assertEquals(actual,expected);
    }
}
