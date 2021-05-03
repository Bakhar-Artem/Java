package by.bakhar.task3.service;

import by.bakhar.task3.entity.Cone;

public interface PassCoordinateAxis {
    boolean passCoordinateAxisXY(Cone cone);
    boolean passCoordinateAxisYZ(Cone cone);
    boolean passCoordinateAxisXZ(Cone cone);
}
