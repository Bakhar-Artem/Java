package by.bakhar.task4.service.impl;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.service.FindService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class FindServiceImpl implements FindService {
    private static Logger logger = LogManager.getLogger();

    private int findMaxWordInSentence(Composite sentence) {
        List<Component> lexemes = sentence.getChildrenList();
        List<Component> words = new ArrayList<>();
        List<Component> possibleWords = new ArrayList<>();
        for (Component component : lexemes) {
            possibleWords.addAll(component.getChildrenList());
        }
        possibleWords.stream().filter(component -> component.getComponentType().equals(ComponentType.WORD)).forEach(words::add);
        Optional<Component> word = words.stream().max(Comparator.comparingInt(Component::getChildrenSize));
        Component wordComponent = word.get();
        return wordComponent.getChildrenSize();
    }

    @Override
    public List<Component> findSentencesWithMaxWord(Composite composite) throws ComponentException {
        if (composite.getComponentType() != ComponentType.TEXT) {
            logger.error("Searching is impossible!");
            throw new ComponentException("Searching is impossible");
        }
        List<Component> paragraphs = composite.getChildrenList();
        List<Component> sentences = new ArrayList<>();
        for (Component paragraph : paragraphs) {
            sentences.addAll(paragraph.getChildrenList());
        }
        sentences.sort(Comparator.comparingInt(sentence -> -findMaxWordInSentence((Composite) sentence)));
        Component firstSentence = sentences.get(0);
        int max = findMaxWordInSentence((Composite) firstSentence);
        List<Component> result = sentences.stream().filter(sentence -> findMaxWordInSentence((Composite) sentence) == max).collect(Collectors.toList());
        return result;
    }

    @Override
    public HashSet<String> findSimilarWord(Composite composite) throws ComponentException {
        if (composite.getComponentType() != ComponentType.TEXT) {
            logger.error("Searching is impossible!");
            throw new ComponentException("Searching is impossible!");
        }
        List<Component> paragraphs = composite.getChildrenList();
        List<Component> sentences = new ArrayList<>();
        for (Component paragraph : paragraphs) {
            sentences.addAll(paragraph.getChildrenList());
        }
        List<Component> lexemes = new ArrayList<>();
        for (Component sentence : sentences) {
            lexemes.addAll(sentence.getChildrenList());
        }
        List<Component> possibleWords = new ArrayList<>();
        for (Component component : lexemes) {
            possibleWords.addAll(component.getChildrenList());
        }
        List<Component> words = new ArrayList<>();
        possibleWords.stream().filter(component -> component.getComponentType().equals(ComponentType.WORD)).forEach(words::add);
        List<String> allWords = new ArrayList<>();
        words.forEach(word -> {
            String temp = word.toString().toLowerCase(Locale.ROOT);
            allWords.add(temp);
        });
        HashSet<String> uniqueWords = new HashSet<>();
        for (int i = 0; i < allWords.size() - 1; i++) {
            for (int j = 1; j < allWords.size(); j++) {
                if (allWords.get(i).equals(allWords.get(j))) {
                    uniqueWords.add(allWords.get(i));
                }
            }
        }
        return uniqueWords;
    }
}
