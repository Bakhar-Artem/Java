package by.bakhar.task3.entity;

import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.observer.ConeEvent;
import by.bakhar.task3.observer.ConeObservable;
import by.bakhar.task3.observer.ConeObserver;
import by.bakhar.task3.util.ConeIdGenerator;
import by.bakhar.task3.validation.ConeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Cone implements ConeObservable<ConeObserver> {
    private static Logger logger = LogManager.getLogger();
    private long id;
    private Point centerPoint;
    private double radius;
    private Point highPoint;
    private List<ConeObserver> observerList;

    public Cone(Point centerPoint, double radius, Point highPoint) throws ConeException {
        if (!ConeValidator.isValidData(centerPoint, radius, highPoint)) {
            logger.error("wrong params " + centerPoint + " " + radius + " " + highPoint);
            throw new ConeException("wrong params " + centerPoint + " " + radius + " " + highPoint);
        }
        this.id = ConeIdGenerator.generateId();
        this.centerPoint = centerPoint;
        this.radius = radius;
        this.highPoint = highPoint;
        observerList = new ArrayList<>();
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

    public void setCenterPoint(Point centerPoint) throws ConeException {
        this.centerPoint = centerPoint;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        this.radius = radius;
        notifyObservers();
    }

    public Point getHighPoint() {
        return highPoint;
    }

    public void setHighPoint(Point highPoint) throws ConeException {
        this.highPoint = highPoint;
        notifyObservers();
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

    @Override
    public void attach(ConeObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(ConeObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() throws ConeException {
        ConeEvent event = new ConeEvent(this);
        for (ConeObserver observer : observerList) {
            observer.updateSquare(event);
            observer.updateVolume(event);
        }
    }
}
