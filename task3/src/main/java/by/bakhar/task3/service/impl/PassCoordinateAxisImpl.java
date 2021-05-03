package by.bakhar.task3.service.impl;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.service.PassCoordinateAxis;

public class PassCoordinateAxisImpl implements PassCoordinateAxis {
    @Override
    public boolean passCoordinateAxisXY(Cone cone) {
        Point center = cone.getCenterPoint();
        double radius = cone.getRadius();
        boolean pass = center.getZ() + radius == 0. || center.getZ() - radius == 0. || (center.getZ() + radius > 0. && center.getZ() - radius < 0.) || (center.getZ() + radius < 0. && center.getZ() - radius > 0.);
        return pass;
    }

    @Override
    public boolean passCoordinateAxisYZ(Cone cone) {
        Point center = cone.getCenterPoint();
        double radius = cone.getRadius();
        boolean pass = center.getX() + radius == 0. || center.getX() - radius == 0. || (center.getX() + radius > 0. && center.getX() - radius < 0.) || (center.getX() + radius < 0. && center.getX() - radius > 0.);
        return pass;
    }

    @Override
    public boolean passCoordinateAxisXZ(Cone cone) {
        Point center = cone.getCenterPoint();
        Point high = cone.getHighPoint();
        boolean pass = (center.getY() > 0. && high.getY() < 0.) || (center.getY() < 0 && high.getY() > 0.) || center.getY() == 0. || high.getY() == 0;
        return pass;
    }
}
