package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SentenceParser implements ComponentParser {
    private static Logger logger = LogManager.getLogger();

    private final static String LEXEME_DELIMITER = "\s";
    private ComponentParser nextParser=new LexemeParser();

    @Override
    public void setNext(ComponentParser parser) {logger.info("parser was chanched to "+parser.getClass());
        nextParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        if(!text.isBlank()){
            String[] lexemes=text.split(LEXEME_DELIMITER);
            for(String lexeme:lexemes){
                Composite lexemeComponent = new Composite(ComponentType.LEXEME);
                nextParser.processData(lexeme, lexemeComponent);
                component.add(lexemeComponent);
            }
        }

    }
}
