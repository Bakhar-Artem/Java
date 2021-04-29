package by.bakhar.task3.specification.impl;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.specification.Specification;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = Long.compare(cone.getId(), id) == 0;
        return result;
    }
}
