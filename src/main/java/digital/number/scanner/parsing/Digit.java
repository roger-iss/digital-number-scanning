package digital.number.scanner.parsing;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

// Note: we represent the digits as a triplet of columns instead of a matrix of 3x3 chars.
// The reason is that potentially we could use between 2x3 OR 3x3 matrices and it would be easier to change the algorithm
// if we wanted to change that.
public enum Digit {
    EMPTY("", new Column(' ', ' ', ' ')),
    ZERO("0", new Column(' ', '|', '|'), new Column('_', ' ', '_'), new Column(' ', '|', '|')),
    ONE("1", new Column(' ', ' ', ' '), new Column(' ', ' ', ' '), new Column(' ', '|', '|')),
    TWO("2", new Column(' ', ' ', '|'), new Column('_', '_', '_'), new Column(' ', '|', ' ')),
    THREE("3", new Column(' ', ' ', ' '), new Column('_', '_', '_'), new Column(' ', '|', '|')),
    FOUR("4", new Column(' ', '|', ' '), new Column(' ', '_', ' '), new Column(' ', '|', '|')),
    FIVE("5", new Column(' ', '|', ' '), new Column('_', '_', '_'), new Column(' ', ' ', '|')),
    SIX("6", new Column(' ', '|', '|'), new Column('_', '_', '_'), new Column(' ', ' ', '|')),
    SEVEN("7", new Column(' ', ' ', ' '), new Column('_', ' ', ' '), new Column(' ', '|', '|')),
    EIGHT("8", new Column(' ', '|', '|'), new Column('_', '_', '_'), new Column(' ', '|', '|')),
    NINE("9", new Column(' ', '|', ' '), new Column('_', '_', '_'), new Column(' ', '|', '|')),
    QUESTION_MARK("?");

    private final String value;
    private final Column column1;
    private final Column column2;
    private final Column column3;

    Digit(String value, Column column1, Column column2, Column column3) {
        this.value = value;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
    }

    Digit(String value, Column column1) {
        this(value, column1, null, null);
    }

    Digit(String value) {
        this(value, null, null, null);
    }

    public String getValue() {
        return value;
    }

    public static Optional<Digit> findMatch(Column column1, Column column2, Column column3) {
        return Arrays.stream(Digit.values())
                .filter(d -> Objects.equals(column1, d.column1) && Objects.equals(column2, d.column2) && Objects.equals(column3, d.column3))
                .findFirst();
    }
}
