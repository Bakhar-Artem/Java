package by.bakhar.task4.service;

import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;

public interface SortService {
    Composite sortParagraphsBySentences(Composite component) throws ComponentException;
}
