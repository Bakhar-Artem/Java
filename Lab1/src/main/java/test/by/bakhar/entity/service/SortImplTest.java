package test.by.bakhar.entity.service;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.service.impl.SortImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SortImplTest {
    private SortImpl sortImpl = new SortImpl();

    @DataProvider(name = "sortedArrays")
    public Object[][] initArrays() {
        return new Object[][]{
                {new DoubleArray(45.7, -60.4, 0, 0, 0, 0, 49.5, 79., -96.2), new double[]{-96.2, -60.4, 0, 0, 0, 0, 45.7, 49.5, 79.}},
                {new DoubleArray(0, 0, 0, 0, 0, 1, 0, 0, -1), new double[]{-1, 0, 0, 0, 0, 0, 0, 0, 1}},
                {new DoubleArray(1.01, 1.05, -1.45, 50.4, 0, 1., 49.5, 79., -96.2), new double[]{-96.2, -1.45, 0, 1., 1.01, 1.05, 49.5, 50.4, 79.}},
                {new DoubleArray(0), new double[0]}
        };
    }

    @Test(dataProvider = "sortedArrays")
    public void testBubbleSort(Object[] data) throws DoubleArrayException {
        sortImpl.bubbleSort((DoubleArray) data[0]);
        double[] actual = ((DoubleArray) data[0]).getArray();
        double[] expected = (double[]) data[1];
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sortedArrays")
    public void testMergeSort(Object[] data) throws DoubleArrayException {
        sortImpl.mergeSort((DoubleArray) data[0]);
        double[] actual = ((DoubleArray) data[0]).getArray();
        double[] expected = (double[]) data[1];
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sortedArrays")
    public void testSelectionSort(Object[] data) throws DoubleArrayException {
        sortImpl.selectionSort((DoubleArray) data[0]);
        double[] actual = ((DoubleArray) data[0]).getArray();
        double[] expected = (double[]) data[1];
        Assert.assertEquals(actual, expected);
    }
}