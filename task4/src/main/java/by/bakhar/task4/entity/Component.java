package by.bakhar.task4.entity;

import java.util.List;

public interface Component {
    void add(Component component);

    void remove(Component component);

    ComponentType getComponentType();

    List<Component> getChildrenList();

    int getChildrenSize();
}
