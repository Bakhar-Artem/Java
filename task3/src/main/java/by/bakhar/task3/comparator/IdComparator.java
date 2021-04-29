package by.bakhar.task3.comparator;

import by.bakhar.task3.entity.Cone;

import java.util.Comparator;

public class IdComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int result = Long.compare(o1.getId(), o2.getId());
        return result;
    }
}
