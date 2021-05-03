package by.bakhar.task3.validation;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;

public class ConeValidator {
    public static boolean isValidData(Point center, double radius, Point high) {
        boolean valid = checkData(center, radius, high);
        return valid;
    }

    public static boolean isValid(Cone cone) {
        Point center = cone.getCenterPoint();
        Point high = cone.getHighPoint();
        double radius = cone.getRadius();
        boolean valid = checkData(center, radius, high);
        return valid;
    }

    private static boolean checkData(Point center, double radius, Point high) {
        boolean valid = (Double.compare(center.getX(), high.getX())==0
                && Double.compare(center.getZ(), high.getZ())==0
                && radius > 0.);
        return valid;
    }
}
