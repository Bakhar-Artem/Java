package by.bakhar.task3.comparator;

import by.bakhar.task3.entity.Cone;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int result = Double.compare(o1.getRadius(), o2.getRadius());
        return result;
    }
}
