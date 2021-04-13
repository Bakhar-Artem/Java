package test.by.bakhar.task3.reader;

import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.reader.ConeReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ConeReaderTest {

    @Test
    public void testReadConeFromFile() throws ConeException {
        ConeReader coneReader=new ConeReader();
        List<String> actual=coneReader.readConeFromFile("src/main/resources/data/data.txt");
        List<String> expected= new ArrayList<>();
        expected.add("2.5 0 1.4 6.5 52.14 2.6 4.");
        expected.add("2.5 15 1.4 -6.5 52.14 2.6 4.");
        Assert.assertEquals(actual,expected);
    }
}