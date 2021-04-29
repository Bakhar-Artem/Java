package by.bakhar.task3.specification.impl;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.specification.Specification;

public class RadiusSpecification implements Specification {
    private double radius;

    public RadiusSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = Double.compare(cone.getRadius(), radius) == 0;
        return result;
    }
}
