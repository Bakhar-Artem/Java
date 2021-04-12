package by.bakhar.task3.validation;

import by.bakhar.task3.entity.Point;

public class ConeValidator {
    public static boolean isValidData(Point center, double radius, Point high) {
        boolean valid = (center.getX() == high.getX()
                && center.getZ() == high.getZ()
                && radius > 0.);
        return valid;
    }
}
