package by.bakhar.task4.entity.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentDelimiter;
import by.bakhar.task4.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Composite implements Component {
    private static Logger logger = LogManager.getLogger();
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
        logger.info("component was removed");
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public int getChildrenSize() {
        return components.size();
    }

    @Override
    public List<Component> getChildrenList() {
        return List.copyOf(components);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (componentType) {

            case PARAGRAPH -> {
                stringBuilder.append(ComponentDelimiter.TAB);
                for (Component component : components) {
                    stringBuilder.append(component);
                }
            }
            case LEXEME -> {
                for (Component component : components) {
                    stringBuilder.append(component);
                }
                stringBuilder.append(ComponentDelimiter.SPACE);
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
