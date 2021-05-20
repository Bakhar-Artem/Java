package by.bakhar.task4.entity.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;

public class Symbol implements Component {
    private char symbol;
    private ComponentType componentType;

    public Symbol(char symbol, ComponentType componentType) {
        this.symbol = symbol;
        this.componentType = componentType;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public Object getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
