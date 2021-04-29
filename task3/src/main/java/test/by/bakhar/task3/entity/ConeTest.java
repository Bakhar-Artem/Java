package test.by.bakhar.task3.entity;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.exception.ConeException;
import org.testng.annotations.Test;

public class ConeTest {
    @Test(expectedExceptions = ConeException.class)
    public void testRadiusConeException() throws ConeException {
        Cone cone = new Cone(new Point(5, 5, 5), -2, new Point(5, 7, 5));
    }

    @Test(expectedExceptions = ConeException.class)
    public void testPointConeException() throws ConeException {
        Cone cone = new Cone(new Point(5, 5, 5), 15.2, new Point(5.6, 7, 5));
    }
    @Test
    public void testConstructorConeException() throws ConeException {
        Cone cone = new Cone(new Point(5.4, 5, 5.9), 3.6, new Point(5.4, 7, 5.9));
    }

}