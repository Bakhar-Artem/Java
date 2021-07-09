package by.bakhar.task4.parser.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.ComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextParser implements ComponentParser {
    private static Logger logger = LogManager.getLogger();
    private final static String PARAGRAPH_DELIMITER = "\t|\s{4}";
    private ComponentParser nextParser=new ParagraphParser();

    @Override
    public void setNext(ComponentParser parser) {
        logger.info("parser was chanched to "+parser.getClass());
        nextParser = parser;
    }

    @Override
    public void processData(String text, Component component) throws ComponentException {
        ComponentType type = component.getComponentType();
        if (type == ComponentType.TEXT) {
            String[] paragraphs=text.split(PARAGRAPH_DELIMITER);
            for (String paragraph:paragraphs){
                if(!paragraph.isBlank()){
                    Component paragraphComponent=new Composite(ComponentType.PARAGRAPH);
                    nextParser.processData(paragraph,paragraphComponent);
                    component.add(paragraphComponent);
                }

            }

        } else {
            nextParser.processData(text, component);
        }
    }
}
