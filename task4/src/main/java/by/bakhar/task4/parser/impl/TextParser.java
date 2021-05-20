package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements ComponentParser {
    private final static String PARAGRAPH_DELIMITER = "\t|\s{4}";
    private ComponentParser componentParser;

    @Override
    public void setNext(ComponentParser parser) {
        componentParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.PARAGRAPH) {
            Pattern paragraphPattern = Pattern.compile(PARAGRAPH_DELIMITER);
            Matcher paragraphMatcher = paragraphPattern.matcher(text);
            int index = 0;
            while (paragraphMatcher.find()) {
                String paragraph = text.substring(index, paragraphMatcher.end());
                index = paragraphMatcher.end();
                Composite paragraphComposite = new Composite(ComponentType.PARAGRAPH);
                component.add(paragraphComposite);
                componentParser.processData(paragraph, paragraphComposite);
            }
        } else {
            componentParser.processData(text, component);
        }
    }
}
