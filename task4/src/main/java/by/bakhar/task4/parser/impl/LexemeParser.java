package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.parser.ComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements ComponentParser {
    private final static String WORD_DELIMITER = "[:\\,-]";
    private ComponentParser componentParser;

    @Override
    public void setNext(ComponentParser parser) {
        componentParser = parser;
    }

    @Override
    public void processData(String text, Component component) {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.LEXEME) {
            Pattern wordPattern = Pattern.compile(WORD_DELIMITER);
            Matcher wordMatcher = wordPattern.matcher(text);
            int index = 0;
            while (wordMatcher.find()) {
                String word = text.substring(index, wordMatcher.end());
                index = wordMatcher.end();
                Composite wordComposite = new Composite(ComponentType.WORD);
                component.add(wordComposite);
                componentParser.processData(word, wordComposite);
            }
        } else {
            componentParser.processData(text, component);
        }
    }
}
