package by.bakhar.task4.entity.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentDelimiter;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.exception.ComponentException;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components;
    private ComponentType componentType;

    public Composite(ComponentType componentType) {
        components = new ArrayList<>();
        this.componentType = componentType;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public Object getChild(int index) throws ComponentException {
        if (index < 0 || index >= components.size()) {
            throw new ComponentException("Bad index! " + index);
        }
        return components.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (componentType) {
            case TEXT -> {
                for (Component component : components) {
                    stringBuilder.append(component).append(ComponentDelimiter.ENTER);
                }
            }
            case PARAGRAPH -> {
                stringBuilder.append(ComponentDelimiter.TAB);
                for (Component component : components) {
                    stringBuilder.append(component).append(ComponentDelimiter.SPACE);
                }
            }
            case SENTENCE -> {
                for (Component component : components) {
                    stringBuilder.append(component).append(ComponentDelimiter.SPACE);
                }
            }
            default -> {
                for (Component component : components) {
                    stringBuilder.append(component);
                }
            }
        }
        return stringBuilder.toString();
    }
}
