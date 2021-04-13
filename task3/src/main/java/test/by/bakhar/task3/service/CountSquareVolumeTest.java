package test.by.bakhar.task3.service;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.service.CountSquareVolume;
import by.bakhar.task3.service.impl.CountSquareVolumeImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountSquareVolumeTest {
    @DataProvider(name = "data")
    public Object[][] initData() throws ConeException {
        return new Object[][]{
                {new Cone(new Point(2.5, 6.4, -2.5), 0.5, new Point(2.5, -5.4, -2.5)), 19.3365, 3.089},
                {new Cone(new Point(1, 0, 1), 3, new Point(1, 4, 1)), 24 * Math.PI, Math.PI * 12}
        };
    }

    @Test(dataProvider = "data")
    public void testCountSquare(Object[] data) {
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double expected = (double) data[1];
        double actual = countSquareVolume.countSquare((Cone) data[0]);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test(dataProvider = "data")
    public void testCountVolume(Object[] data) {
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double expected = (double) data[2];
        double actual = countSquareVolume.countVolume((Cone) data[0]);
        Assert.assertEquals(expected, actual, 0.001);
    }
}