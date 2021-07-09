package by.bakhar.task4.entity.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements Component {
    private static Logger logger = LogManager.getLogger();
    private char symbol;
    private ComponentType componentType;

    public Symbol(char symbol, ComponentType componentType) {
        this.symbol = symbol;
        this.componentType = componentType;
    }

    @Override
    public void add(Component component) {
        logger.error("method add unsupported!");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        logger.error("method remove unsupported!");
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public List<Component> getChildrenList() {
        logger.error("method getChildrenList unsupported!");
        throw new UnsupportedOperationException();
    }

    @Override
    public int getChildrenSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
