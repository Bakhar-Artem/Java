package test.by.bakhar.task3.observer;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.ConeParameters;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.entity.Warehouse;
import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.observer.impl.ConeObserverImpl;
import by.bakhar.task3.service.CountSquareVolume;
import by.bakhar.task3.service.impl.CountSquareVolumeImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ConeObserverTest {
    private Cone cone;
    private Warehouse warehouse = Warehouse.getInstance();

    @BeforeTest
    public void setUp() throws ConeException {
        cone = new Cone(new Point(0, 5, 0), 4, new Point(0, 7, 0));
        cone.attach(new ConeObserverImpl());
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double square = countSquareVolume.countSquare(cone);
        double volume = countSquareVolume.countVolume(cone);
        ConeParameters coneParameters = new ConeParameters(square, volume);
        warehouse.putCone(cone.getId(), coneParameters);
    }

    @Test
    public void testUpdateSquare() throws ConeException {
        cone.setRadius(5);
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double expectedSquare = countSquareVolume.countSquare(cone);
        ConeParameters params = warehouse.getConeParameters(cone.getId());
        double actualSquare = params.getSquare();
        Assert.assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void testUpdateVolume() throws ConeException {
        cone.setHighPoint(new Point(0, -2.4, 0));
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double expectedVolume = countSquareVolume.countVolume(cone);
        ConeParameters params = warehouse.getConeParameters(cone.getId());
        double actualVolume = params.getVolume();
        Assert.assertEquals(expectedVolume, actualVolume);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testUpdateException() throws ConeException {
        Cone cone1 = new Cone(new Point(0, 5, 0), 4, new Point(0, 7, 0));
        cone1.attach(new ConeObserverImpl());
        cone1.setHighPoint(new Point(-5.4, 5, 0));
    }
}