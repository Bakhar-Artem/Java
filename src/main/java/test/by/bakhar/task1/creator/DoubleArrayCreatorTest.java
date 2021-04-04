package test.by.bakhar.task1.creator;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.creator.DoubleArrayCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleArrayCreatorTest {
    DoubleArrayCreator doubleArrayCreator = new DoubleArrayCreator();

    @Test
    public void testCreate() {
        double[] data = {15, 47.3, 46.4, 2d};
        DoubleArray expected = new DoubleArray(data);
        DoubleArray actual = doubleArrayCreator.create(data);
        Assert.assertEquals(expected, actual);
    }
}