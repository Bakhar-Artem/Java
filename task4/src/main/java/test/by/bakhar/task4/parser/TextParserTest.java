package test.by.bakhar.task4.parser;

import by.bakhar.task4.entity.Component;
import by.bakhar.task4.entity.ComponentType;
import by.bakhar.task4.entity.impl.Composite;
import by.bakhar.task4.exception.ComponentException;
import by.bakhar.task4.parser.impl.TextParser;
import by.bakhar.task4.reader.impl.TextReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TextParserTest {
    private final static String FILE_PATH = "src\\main\\resources\\data\\text.txt";

    @Test
    public void testProcessData() throws IOException, ComponentException {
        TextParser textParser = new TextParser();
        TextReaderImpl reader = new TextReaderImpl();
        String text = reader.readTextFromTxt(FILE_PATH);
        Component textComponent = new Composite(ComponentType.TEXT);
        textParser.processData(text, textComponent);
        String actual = textComponent.toString();
        String expected = "    It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
                "    It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
                "    It is a established fact that a reader will be of a page when looking at its layout...\n" +
                "    Bye бандерлоги.";
        Assert.assertEquals(expected,actual);
    }
}