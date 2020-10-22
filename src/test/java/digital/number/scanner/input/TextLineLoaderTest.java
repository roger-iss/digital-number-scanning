package digital.number.scanner.input;

import digital.number.scanner.exceptions.FileParsingException;
import digital.number.scanner.exceptions.ParsingException;
import digital.number.scanner.parsing.Line;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class TextLineLoaderTest {

    @Test
    public void loadLines() throws ParsingException, FileParsingException {
        // Arrange
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());

        LineLoader lineLoader = new TextLineLoader(file.getAbsolutePath());

        // Act
        List<Line> lines = lineLoader.loadLines();

        // Assert
        assertTrue(lines.size() > 0);
    }
}