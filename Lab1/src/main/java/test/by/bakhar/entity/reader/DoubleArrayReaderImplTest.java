package test.by.bakhar.entity.reader;

import by.bakhar.entity.exception.DoubleArrayReaderException;
import by.bakhar.entity.reader.DoubleArrayReader;
import by.bakhar.entity.reader.impl.DoubleArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoubleArrayReaderImplTest {
    DoubleArrayReader reader = new DoubleArrayReaderImpl();

    @Test
    public void testReadFromTxt() throws DoubleArrayReaderException {
        List<String> expected = new ArrayList<>();
        expected.add("15.4, 78.2, 25.4, 0, 2d");
        List<String> actual = reader.readFromTxt();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadFromTxtEmpty() throws DoubleArrayReaderException {
        List<String> expected = new ArrayList<>();
        List<String> actual = reader.readFromTxt();
        Assert.assertEquals(expected, actual);
    }
}