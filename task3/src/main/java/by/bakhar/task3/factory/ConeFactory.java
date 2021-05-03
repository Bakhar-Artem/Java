package by.bakhar.task3.factory;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeFactory {
    private static Logger logger = LogManager.getLogger();

    public static Cone createCone(double[] coneDouble) throws ConeException {
        if (coneDouble.length != ConeFactoryParameters.NUMBER_OF_PARAMS) {
            logger.error("wrong array length" + coneDouble.length);
            throw new ConeException("wrong array length" + coneDouble.length);
        }
        Point center = new Point(coneDouble[0], coneDouble[1], coneDouble[2]);
        double radius = coneDouble[3];
        Point high = new Point(coneDouble[4], coneDouble[5], coneDouble[6]);
        Cone cone = new Cone(center, radius, high);
        return cone;
    }
}
