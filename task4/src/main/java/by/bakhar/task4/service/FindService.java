package by.bakhar.task4.service;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;

import java.util.HashSet;
import java.util.List;

public interface FindService {
    List<Component> findSentencesWithMaxWord(Composite composite) throws ComponentException;

    HashSet<String> findSimilarWord(Composite composite) throws ComponentException;
}
