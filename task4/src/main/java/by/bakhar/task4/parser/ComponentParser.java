package by.bakhar.task4.parser;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.exception.ComponentException;

public interface ComponentParser {
    void setNext(ComponentParser nextParser);

    void processData(String text, Component component) throws ComponentException;
}
