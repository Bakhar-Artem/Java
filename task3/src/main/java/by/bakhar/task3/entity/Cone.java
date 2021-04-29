package by.bakhar.task3.entity;

import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.utils.ConeIdGenerator;
import by.bakhar.task3.validation.ConeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Cone {
    static Logger logger = LogManager.getLogger();
    private long id;
    private Point centerPoint;
    private double radius;
    private Point highPoint;

    public Cone(Point centerPoint, double radius, Point highPoint) throws ConeException {
        if (!ConeValidator.isValidData(centerPoint, radius, highPoint)) {
            logger.error("wrong params " + centerPoint + " " + radius + " " + highPoint);
            throw new ConeException("wrong params " + centerPoint + " " + radius + " " + highPoint);
        }
        this.id = ConeIdGenerator.generateId();
        this.centerPoint = centerPoint;
        this.radius = radius;
        this.highPoint = highPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getHighPoint() {
        return highPoint;
    }

    public void setHighPoint(Point highPoint) {
        this.highPoint = highPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cone)) {
            return false;
        }
        Cone cone = (Cone) o;
        return Long.compare(id, cone.id) == 0 && Double.compare(cone.radius, radius) == 0 && centerPoint.equals(cone.centerPoint) && highPoint.equals(cone.highPoint);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (13 * id) % 101;
        hash += (13 * centerPoint.hashCode()) % 101;
        hash += (13 * Double.hashCode(radius)) % 101;
        hash += (13 * highPoint.hashCode()) % 101;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(id);
        stringBuilder.append(", centerPoint: ").append(centerPoint);
        stringBuilder.append(", radius: ").append(radius);
        stringBuilder.append(", highPoint: ").append(highPoint);
        return stringBuilder.toString();
    }
}
