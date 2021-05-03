package by.bakhar.task3.observer;

import by.bakhar.task3.exception.ConeException;

public interface ConeObservable<T extends ConeObserver> {
    void attach(T observer);

    void detach(T observer);

    void notifyObservers() throws ConeException;
}
