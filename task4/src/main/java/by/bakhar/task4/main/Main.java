package by.bakhar.task4.main;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.impl.TextParser;
import by.bakhar.task4.reader.TextReader;
import by.bakhar.task4.reader.impl.TextReaderImpl;
import by.bakhar.task4.service.FindService;
import by.bakhar.task4.service.SortService;
import by.bakhar.task4.service.impl.FindServiceImpl;
import by.bakhar.task4.service.impl.SortServiceImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ComponentException {
        TextReader textReader = new TextReaderImpl();
        String text = textReader.readTextFromTxt("src\\main\\resources\\data\\text.txt");
        //System.out.println(text);
        Component textComponent = new Composite(ComponentType.TEXT);
        TextParser textParser = new TextParser();
        textParser.processData(text, textComponent);
        System.out.println(textComponent.toString());
        SortService sortService = new SortServiceImpl();
        Component sortedText = sortService.sortParagraphsBySentences((Composite) textComponent);
        FindService findService = new FindServiceImpl();
        List<Component> sentences = findService.findSentencesWithMaxWord((Composite) textComponent);
        System.out.println(sortedText);
        System.out.println(sentences);
        System.out.println(findService.findSimilarWord((Composite) textComponent));
    }
}
