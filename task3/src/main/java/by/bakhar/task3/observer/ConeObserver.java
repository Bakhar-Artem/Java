package by.bakhar.task3.observer;

import by.bakhar.task3.exception.ConeException;

public interface ConeObserver {
    void updateSquare(ConeEvent coneEvent) throws ConeException;

    void updateVolume(ConeEvent coneEvent) throws ConeException;
}
