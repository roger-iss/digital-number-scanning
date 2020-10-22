package digital.number.scanner.parsing;

import digital.number.scanner.exceptions.ParsingException;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testToString_valid() throws ParsingException {

        // Arrange
        Line line = new Line("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|");

        // Act
        String parsedString = line.toString();

        // Assert
        assertEquals("123456789", parsedString);
    }

    @Test
    public void testToString_invalid() throws ParsingException {

        // Arrange
        Line line = new Line("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|| ||_| _|");

        // Act
        String parsedString = line.toString();

        // Assert
        assertEquals("123456?89 ILL", parsedString);
    }

    @Test(expected = ParsingException.class)
    public void testToString_not_multiple_of_3_should_throw_an_error() throws ParsingException {

        // Arrange
        Line line = new Line(" ", "|", "|");

        // Act
        String parsedString = line.toString();
    }

    @Test(expected = ParsingException.class)
    public void testToString_with_null_should_throw_an_error() throws ParsingException {

        // Arrange
        Line line = new Line(" ", "|", null);

        // Act
        String parsedString = line.toString();
    }
}