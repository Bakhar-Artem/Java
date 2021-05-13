package by.bakhar.task4.parser;

import by.bakhar.task4.entity.Component;

public interface ComponentParser {
    void setNext(ComponentParser parser);

    void processData(String text, Component component);
}
