package test.by.bakhar.task3.repository;

import by.bakhar.task3.comparator.CenterPointXComparator;
import by.bakhar.task3.comparator.IdComparator;
import by.bakhar.task3.comparator.RadiusComparator;
import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.Point;
import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.repository.Repository;
import by.bakhar.task3.repository.impl.ConeRepository;
import by.bakhar.task3.specification.impl.IdSpecification;
import by.bakhar.task3.specification.impl.RadiusSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeRepositoryTest {
    private Repository repository = ConeRepository.getInstance();
    private List<Cone> sortedByX = new ArrayList<>();
    private List<Cone> sortedById = new ArrayList<>();
    private List<Cone> sortedByRadius = new ArrayList<>();
    private List<Cone> idSpecification = new ArrayList<>();
    private List<Cone> radiusSpecification = new ArrayList<>();

    @BeforeTest
    public void sutUp() throws ConeException {
        Cone cone1 = new Cone(new Point(0, 5, 0), 4, new Point(0, 7, 0));
        Cone cone2 = new Cone(new Point(-5.4, 5, 5.9), 5.6, new Point(-5.4, 15.4, 5.9));
        Cone cone3 = new Cone(new Point(17.4, -9.6, 5.9), 3.6, new Point(17.4, 10, 5.9));
        repository.addCone(cone1);
        repository.addCone(cone2);
        repository.addCone(cone3);
        sortedByX.add(cone2);
        sortedByX.add(cone1);
        sortedByX.add(cone3);
        sortedById.add(cone1);
        sortedById.add(cone2);
        sortedById.add(cone3);
        sortedByRadius.add(cone3);
        sortedByRadius.add(cone1);
        sortedByRadius.add(cone2);
        idSpecification.add(cone2);
        radiusSpecification.add(cone1);
        radiusSpecification.add(cone3);
    }

    @Test
    public void testFindByIdSpecification() {
        List<Cone> actual = repository.findBySpecification(new IdSpecification(2));
        Assert.assertEquals(actual, idSpecification);
    }

    @Test
    public void testFindByRadiusSpecification() {
        List<Cone> actual = repository.findBySpecification(new RadiusSpecification(2.0, 5.2));
        Assert.assertEquals(actual, radiusSpecification);
    }

    @Test
    public void testSortByX() throws ConeException {

        List<Cone> actual = repository.sort(new CenterPointXComparator());
        Assert.assertEquals(actual, sortedByX);
    }

    @Test
    public void testSortById() {
        List<Cone> actual = repository.sort(new IdComparator());
        Assert.assertEquals(actual, sortedById);
    }

    @Test
    public void testSortByRadius() {
        List<Cone> actual = repository.sort(new RadiusComparator());
        Assert.assertEquals(actual, sortedByRadius);
    }
}