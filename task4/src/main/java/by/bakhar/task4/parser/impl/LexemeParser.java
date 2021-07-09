package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.entity.impl.Symbol;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class LexemeParser implements ComponentParser {
    private static Logger logger = LogManager.getLogger();
    private final static String WORD_REGEX = "[a-zA-Zа-яА-я]+";
    private final static String PUNCTUATION_DELIMITER = "\\p{P}";
    private ComponentParser nextParser = new WordParser();

    @Override
    public void setNext(ComponentParser parser) {
        logger.info("parser was chanched to " + parser.getClass());
        nextParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.LEXEME) {
            if (!text.isBlank()) {
                char[] symbols = text.toCharArray();
                StringBuilder wordBuilder = new StringBuilder();
                for (int i = 0; i < symbols.length; i++) {
                    if (Pattern.matches(PUNCTUATION_DELIMITER, String.valueOf(symbols[i]))) {
                        if (!wordBuilder.isEmpty()) {
                            Component wordComponent = new Composite(ComponentType.WORD);
                            nextParser.processData(wordBuilder.toString(), wordComponent);
                            wordBuilder = new StringBuilder();
                            component.add(wordComponent);
                        }
                        component.add(new Symbol(symbols[i], ComponentType.PUNCTUATION));
                    } else {
                        wordBuilder.append(symbols[i]);
                    }
                }
                if (!wordBuilder.isEmpty()) {
                    Component wordComponent = new Composite(ComponentType.WORD);
                    nextParser.processData(wordBuilder.toString(), wordComponent);
                    component.add(wordComponent);
                }
            }

        } else {
            nextParser.processData(text, component);
        }
    }
}
