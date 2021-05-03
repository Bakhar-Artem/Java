package by.bakhar.task3.observer;

import by.bakhar.task3.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {

    public ConeEvent(Object source) {
        super(source);
    }

    @Override
    public Cone getSource() {
        return (Cone) super.getSource();
    }
}
