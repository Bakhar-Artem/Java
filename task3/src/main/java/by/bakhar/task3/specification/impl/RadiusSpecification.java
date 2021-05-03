package by.bakhar.task3.specification.impl;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.specification.Specification;

public class RadiusSpecification implements Specification {
    private double lowerBound;
    private double upperBound;

    public RadiusSpecification(double lowerBound, double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean specify(Cone cone) {
        double radius = cone.getRadius();
        boolean result = (radius >= lowerBound && radius <= upperBound);
        return result;
    }
}
