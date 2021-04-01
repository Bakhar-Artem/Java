package test.by.bakhar.entity.service;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.service.FindValueService;
import by.bakhar.entity.service.impl.FindValueImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FindValueServiceTest {
    private FindValueService findValue = new FindValueImpl();

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderInit() {
        return new Object[][]{
                {new DoubleArray(5.4, 76, 0, 1.9), 76., 0.},
                {new DoubleArray(0, 0, 0, 0), 0., 0.},
                {new DoubleArray(5.4, -75.14, -75.1, 65.17), 65.17, -75.14},
                {new DoubleArray(5.4, 76, 0, 1.9), 76., 0.},
                {new DoubleArray(-5.4, 0, 1, 49), 49., -5.4}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testFindMax(Object[] data) throws DoubleArrayException {
        double expected = (double) data[1];
        double actual = findValue.findMax((DoubleArray) data[0]);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testFindMaxDoubleStream(Object[] data) throws DoubleArrayException {
        double expected = (double) data[1];
        double actual = findValue.findMaxDoubleStream((DoubleArray) data[0]);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testFindMin(Object[] data) throws DoubleArrayException {
        double expected = (double) data[2];
        double actual = findValue.findMin((DoubleArray) data[0]);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataProvider")
    public void testFindMinDoubleStream(Object[] data) throws DoubleArrayException {
        double expected = (double) data[2];
        double actual = findValue.findMinDoubleStream((DoubleArray) data[0]);
        Assert.assertEquals(expected, actual);
    }

    @DataProvider(name = "nullPointerProvider")
    public Object[][] nullPointerArraysInit() {
        return new Object[][]{
                {new DoubleArray()},
        };
    }

    @Test(expectedExceptions = DoubleArrayException.class,dataProvider = "nullPointerProvider")
    public void testDoubleArrayException(Object[] data) throws DoubleArrayException {
        findValue.findMax((DoubleArray) data[0]);
    }
}