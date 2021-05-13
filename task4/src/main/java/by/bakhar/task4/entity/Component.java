package by.bakhar.task4.entity;

import by.bakhar.task4.exception.ComponentException;

public interface Component {
    void add(Component component);

    void remove(Component component);

    ComponentType getComponentType();

    Object getChild(int index) throws ComponentException;
}
