package digital.number.scanner.parsing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class DigitTest {

    @Test
    public void findMatch_three_matching_columns() {
        Assert.assertEquals("0", Digit.findMatch(new Column(' ', '|', '|'), new Column('_', ' ', '_'), new Column(' ', '|', '|')).get().getValue());
        Assert.assertEquals("1", Digit.findMatch(new Column(' ', ' ', ' '), new Column(' ', ' ', ' '), new Column(' ', '|', '|')).get().getValue());
        Assert.assertEquals("2", Digit.findMatch(new Column(' ', ' ', '|'), new Column('_', '_', '_'), new Column(' ', '|', ' ')).get().getValue());
        Assert.assertEquals("3", Digit.findMatch(new Column(' ', ' ', ' '), new Column('_', '_', '_'), new Column(' ', '|', '|')).get().getValue());
        Assert.assertEquals("4", Digit.findMatch(new Column(' ', '|', ' '), new Column(' ', '_', ' '), new Column(' ', '|', '|')).get().getValue());
        Assert.assertEquals("5", Digit.findMatch(new Column(' ', '|', ' '), new Column('_', '_', '_'), new Column(' ', ' ', '|')).get().getValue());
        Assert.assertEquals("6", Digit.findMatch(new Column(' ', '|', '|'), new Column('_', '_', '_'), new Column(' ', ' ', '|')).get().getValue());
        Assert.assertEquals("7", Digit.findMatch(new Column(' ', ' ', ' '), new Column('_', ' ', ' '), new Column(' ', '|', '|')).get().getValue());
        Assert.assertEquals("8", Digit.findMatch(new Column(' ', '|', '|'), new Column('_', '_', '_'), new Column(' ', '|', '|')).get().getValue());
        Assert.assertEquals("9", Digit.findMatch(new Column(' ', '|', ' '), new Column('_', '_', '_'), new Column(' ', '|', '|')).get().getValue());
    }

    @Test
    public void findMatch_three_non_matching_columns() {
        // Arrange & Act
        Optional<Digit> opt = Digit.findMatch(new Column(' ', ' ', '|'), new Column('_', '_', '_'), new Column('_', '|', ' '));

        // Assert
        Assert.assertFalse(opt.isPresent());
    }
}