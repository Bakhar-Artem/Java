package by.bakhar.task3.comparator;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;

import java.util.Comparator;

public class CenterPointXComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        Point center1 = o1.getCenterPoint();
        Point center2 = o2.getCenterPoint();
        return Double.compare(center1.getX(), center2.getX());
    }
}
