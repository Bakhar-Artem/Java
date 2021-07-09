package test.by.bakhar.task4.service;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.impl.TextParser;
import by.bakhar.task4.reader.impl.TextReaderImpl;
import by.bakhar.task4.service.FindService;
import by.bakhar.task4.service.impl.FindServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindServiceImplTest {
    private final static String FILE_PATH = "src\\main\\resources\\data\\text.txt";
    private final static String FILEPATH = "src\\main\\test_resources\\test.txt";
    private Component textComponent;

    @BeforeTest
    public void setUp() throws IOException, ComponentException {
        TextParser textParser = new TextParser();
        TextReaderImpl reader = new TextReaderImpl();
        String text = reader.readTextFromTxt(FILE_PATH);
        textComponent = new Composite(ComponentType.TEXT);
        textParser.processData(text, textComponent);
    }

    @Test
    public void testFindSentencesWithMaxWord() throws ComponentException {
        FindService findService = new FindServiceImpl();
        List<Component> actual = findService.findSentencesWithMaxWord((Composite) textComponent);
        List<String> expected = new ArrayList<>();
        expected.add("The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?");
        Assert.assertEquals(expected.get(0), actual.get(0).toString());
    }

    @Test
    public void testFindSimilarWord() throws ComponentException, IOException {
        TextParser textParser = new TextParser();
        TextReaderImpl reader = new TextReaderImpl();
        String text = reader.readTextFromTxt(FILEPATH);
        textComponent = new Composite(ComponentType.TEXT);
        textParser.processData(text, textComponent);
        FindService findService = new FindServiceImpl();
        HashSet<String> actual = findService.findSimilarWord((Composite) textComponent);
        HashSet<String> expected = new HashSet<>();
        expected.add("будет");
        expected.add("ползать");
        expected.add("не");
        Assert.assertEquals(actual,expected);
    }
}