package by.bakhar.task4.service.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class SortServiceImpl implements SortService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public Composite sortParagraphsBySentences(Composite component) throws ComponentException {
        if (component.getComponentType() != ComponentType.TEXT) {
            logger.error("Impossible to sort!");
            throw new ComponentException("Impossible to sort!");
        }
        List<Component> paragraphList = component.getChildrenList();
        Composite sortedComponent = new Composite(ComponentType.TEXT);
        paragraphList.stream().sorted(Comparator.comparingInt(Component::getChildrenSize)).forEach(sortedComponent::add);
        logger.info("Paragraphs were sorted!");
        return sortedComponent;
    }
}
