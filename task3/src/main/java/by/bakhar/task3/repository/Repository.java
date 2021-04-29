package by.bakhar.task3.repository;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.specification.Specification;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {
    void addCone(Cone cone);

    void addAllCones(Collection<Cone> cones);

    void removeCone(Cone cone);

    void removeAllCones(Collection<Cone> cones);

    List<Cone> findBySpecification(Specification specification);

    List<Cone> sort(Comparator<Cone> coneComparator);
}
