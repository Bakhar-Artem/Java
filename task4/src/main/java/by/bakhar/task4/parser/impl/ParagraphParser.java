package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements ComponentParser {
    private final static String SENTENCE_DELIMITER = "[\\.?!\\.{3}]";
    private ComponentParser componentParser;

    @Override
    public void setNext(ComponentParser parser) {
        componentParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.PARAGRAPH) {
            Pattern sentencePattern = Pattern.compile(SENTENCE_DELIMITER);
            Matcher sentenceMatcher = sentencePattern.matcher(text);
            int index = 0;
            while (sentenceMatcher.find()) {
                String sentence = text.substring(index, sentenceMatcher.end());
                index = sentenceMatcher.end();
                Composite sentenceComposite = new Composite(ComponentType.SENTENCE);
                component.add(sentenceComposite);
                componentParser.processData(sentence, sentenceComposite);
            }
        } else {
            componentParser.processData(text, component);
        }
    }
}
