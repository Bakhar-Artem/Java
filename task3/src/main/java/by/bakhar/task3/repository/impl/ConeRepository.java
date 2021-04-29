package by.bakhar.task3.repository.impl;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.repository.Repository;
import by.bakhar.task3.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository implements Repository {
    private static Logger logger = LogManager.getLogger();
    private List<Cone> cones;
    private static ConeRepository instance;

    private ConeRepository() {
        cones = new ArrayList<>();
    }

    public static ConeRepository getInstance() {
        if (instance == null) {
            instance = new ConeRepository();
        }
        return instance;
    }

    @Override
    public void addCone(Cone cone) {
        cones.add(cone);
        logger.info("Cone was add! " + cone.toString());
    }

    @Override
    public void addAllCones(Collection<Cone> conesCollection) {
        cones.addAll(conesCollection);
        logger.info("Cones were add!");
    }

    @Override
    public void removeCone(Cone cone) {
        cones.remove(cone);
        logger.info("Cone was removed! " + cone.toString());
    }

    @Override
    public void removeAllCones(Collection<Cone> conesCollection) {
        cones.removeAll(conesCollection);
        logger.info("Cones were removed! ");
    }

    @Override
    public List<Cone> findBySpecification(Specification specification) {
        List<Cone> result = new ArrayList<>();
        cones.stream().filter(specification::specify).forEach(result::add);
        logger.info("Cones were specified by " + specification.getClass());
        return result;
    }

    @Override
    public List<Cone> sort(Comparator<Cone> coneComparator) {
        List<Cone> result = cones.stream().sorted(coneComparator::compare).collect(Collectors.toList());
        logger.info("Cones were sorted by " + coneComparator.getClass());
        return result;
    }
}
