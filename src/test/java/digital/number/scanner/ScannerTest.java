package digital.number.scanner;

import digital.number.scanner.exceptions.FileParsingException;
import digital.number.scanner.exceptions.ParsingException;
import digital.number.scanner.input.LineLoader;
import digital.number.scanner.output.NumberDisplayer;
import digital.number.scanner.parsing.Line;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ScannerTest {

    @Test
    public void scan() throws ParsingException, FileParsingException {

        // Arrange
        LineLoader lineLoader = mock(LineLoader.class);
        when(lineLoader.loadLines()).thenReturn(Arrays.asList(
                new Line("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|"),
                new Line("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|")));

        NumberDisplayer numberDisplayer = mock(NumberDisplayer.class);

        Scanner scanner = new Scanner(lineLoader, numberDisplayer);

        // Act
        scanner.scan();

        // Assert
        verify(lineLoader, times(1)).loadLines();
        verify(numberDisplayer, times(2)).display(anyString());
    }

    @Test
    public void scan_displayError() throws ParsingException, FileParsingException {

        // Arrange
        LineLoader lineLoader = mock(LineLoader.class);
        when(lineLoader.loadLines()).thenThrow(new ParsingException("some exception"));
        NumberDisplayer numberDisplayer = mock(NumberDisplayer.class);

        Scanner scanner = new Scanner(lineLoader, numberDisplayer);

        // Act
        scanner.scan();

        // Assert
        verify(numberDisplayer, times(1)).display(anyString());
    }
}