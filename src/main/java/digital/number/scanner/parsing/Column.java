package digital.number.scanner.parsing;

import java.util.Objects;

public  class Column {
    private final char line1;
    private final char line2;
    private final char line3;

    public Column(char line1, char line2, char line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return line1 == column.line1 &&
                line2 == column.line2 &&
                line3 == column.line3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line1, line2, line3);
    }
}