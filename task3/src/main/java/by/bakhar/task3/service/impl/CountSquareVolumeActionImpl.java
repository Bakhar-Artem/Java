package by.bakhar.task3.service.impl;

import by.bakhar.task3.service.CountSquareVolumeAction;
import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;

public class CountSquareVolumeActionImpl implements CountSquareVolumeAction {
    @Override
    public double countSquare(Cone cone) {
        double forming = countForming(cone);
        double radius = cone.getRadius();
        double square = Math.PI * radius * (forming + radius);
        return square;
    }

    @Override
    public double countVolume(Cone cone) {
        double radius = cone.getRadius();
        double high = countHigh(cone);
        double volume = 1. / 3 * Math.PI * Math.pow(radius, 2) * high;
        return volume;
    }

    private double countForming(Cone cone) {
        double high = countHigh(cone);
        double forming = Math.pow(high, 2) + Math.pow(cone.getRadius(), 2);
        forming = Math.pow(forming, 0.5);
        return forming;
    }

    private double countHigh(Cone cone) {
        Point highPoint = cone.getHighPoint();
        Point centerPoint = cone.getCenterPoint();
        double high = Math.abs(highPoint.getY() - centerPoint.getY());
        return high;
    }
}
