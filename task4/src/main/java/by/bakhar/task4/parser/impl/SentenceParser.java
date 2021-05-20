package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements ComponentParser {
    private final static String LEXEME_DELIMITER = "\s";
    private ComponentParser componentParser;

    @Override
    public void setNext(ComponentParser parser) {
        componentParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.SENTENCE) {
            Pattern lexemePattern = Pattern.compile(LEXEME_DELIMITER);
            Matcher lexemeMatcher = lexemePattern.matcher(text);
            int index = 0;
            while (lexemeMatcher.find()) {
                String lexeme = text.substring(index, lexemeMatcher.end());
                index = lexemeMatcher.end();
                Composite lexemeComposite = new Composite(ComponentType.LEXEME);
                component.add(lexemeComposite);
                componentParser.processData(lexeme, lexemeComposite);
            }
        } else {
            componentParser.processData(text, component);
        }
    }
}
