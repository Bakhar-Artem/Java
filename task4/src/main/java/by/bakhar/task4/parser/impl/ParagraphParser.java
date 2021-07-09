package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParagraphParser implements ComponentParser {
    private static Logger logger = LogManager.getLogger();

    private final static String SENTENCE_DELIMITER = "[?.!]\s|\n";
    private ComponentParser nextParser = new SentenceParser();

    @Override
    public void setNext(ComponentParser parser) {logger.info("parser was chanched to "+parser.getClass());
        nextParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        Pattern sentencePattern = Pattern.compile(SENTENCE_DELIMITER);
        Matcher sentenceMatcher = sentencePattern.matcher(text);
        if(!text.isBlank()){
            int index = 0;
            while (sentenceMatcher.find()) {
                String sentence = text.substring(index, sentenceMatcher.end());
                index = sentenceMatcher.end();
                Composite sentenceTextComposite = new Composite(ComponentType.SENTENCE);
                component.add(sentenceTextComposite);
                nextParser.processData(sentence, sentenceTextComposite);
            }
        }

    }
}
