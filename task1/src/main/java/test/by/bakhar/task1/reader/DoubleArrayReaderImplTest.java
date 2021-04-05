package test.by.bakhar.task1.reader;

import by.bakhar.task1.exception.DoubleArrayReaderException;
import by.bakhar.task1.reader.DoubleArrayReader;
import by.bakhar.task1.reader.impl.DoubleArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DoubleArrayReaderImplTest {
    DoubleArrayReader reader = new DoubleArrayReaderImpl();

    @Test
    public void testReadFromTxt() throws DoubleArrayReaderException {
        List<String> expected = new ArrayList<>();
        expected.add("15.4, 78.2, 25.4, 0, 2d");
        expected.add("15.4, 78.2, 25.4,2d");
        expected.add("0,1,35.4");
        List<String> actual = reader.readFromTxt("src/main/resources/data/data.txt");
        Assert.assertEquals(expected, actual);
    }
}