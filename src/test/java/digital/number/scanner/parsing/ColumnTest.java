package digital.number.scanner.parsing;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTest {

    @Test
    public void equals() {
        assertEquals(new Column(' ', ' ', ' '), new Column(' ', ' ', ' '));
        assertNotEquals(new Column(' ', ' ', ' '), new Column(' ', ' ', '|'));
    }
}