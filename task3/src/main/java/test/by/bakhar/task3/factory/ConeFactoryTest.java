package test.by.bakhar.task3.factory;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.factory.ConeFactory;
import by.bakhar.task3.reader.ConeReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeFactoryTest {

    @Test(expectedExceptions = ConeException.class)
    public void testCreateConeBad() throws ConeException {
        Cone actual = ConeFactory.createCone(new double[]{2.5, 15, 1.4, -6.5, 52.14, 2.6, 4.});
    }

    @Test
    public void testCreateConeGood() throws ConeException {
        Cone expected = new Cone(new Point(2.5, 6.4, -2.5), 0.5, new Point(2.5, -5.4, -2.5));
        Cone actual = ConeFactory.createCone(new double[]{2.5, 6.4, -2.5, 0.5, 2.5, -5.4, -2.5});
        Assert.assertEquals(actual, expected);
    }
}