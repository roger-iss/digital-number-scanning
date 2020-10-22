package digital.number.scanner.parsing;

import digital.number.scanner.exceptions.ParsingException;

import java.util.*;

public class Line {

    private final String value;

    public Line(CharSequence line1, CharSequence line2, CharSequence line3) throws ParsingException {
        if (line1 == null || line2 == null || line3 == null) {
            throw new ParsingException("The 3 lines must be non-null");
        }

        value = parseColumnsToDigits(parseLinesToColumns(line1, line2, line3)); // We parse the number in the constructor
    }

    public String toString() {
        return value;
    }

    // This method extracts the characters of the 3 lines into a queue of columns
    private static Queue<Column> parseLinesToColumns(CharSequence line1, CharSequence line2, CharSequence line3) {

        Queue<Column> queue = new LinkedList<>();

        int size = Math.max(Math.max(line1.length(), line2.length()), line3.length());

        for (int i = 0; i < size; i++) {
            queue.add(new Column(getIthChar(line1, i), getIthChar(line2, i), getIthChar(line3, i)));
        }

        return queue;
    }

    private static char getIthChar(CharSequence line, int i) {
        return (i < line.length()) ? line.charAt(i) : ' '; // if a line is shorter than the others, we pad it with ' '
    }

    private static void markInvalidDigit(StringBuilder sb) {
        sb.append(Digit.QUESTION_MARK.getValue());
    }

    private static void markValidDigit(StringBuilder sb, Digit digit) {
        sb.append(digit.getValue());
    }

    // This method parses columns into digits
    private static String parseColumnsToDigits(Queue<Column> columns) throws ParsingException {

        if (columns.size() < 3 && columns.size() % 3 > 0) {
            throw new ParsingException("The number of columns must be a multiple of 3 strictly positive");
        }

        StringBuilder sb = new StringBuilder();

        boolean isIll = false;

        while(!columns.isEmpty()) {

            Column c1 = columns.poll();
            Column c2 = columns.poll();
            Column c3 = columns.poll();

            Optional<Digit> digit = Digit.findMatch(c1, c2, c3);
            if (digit.isPresent()) {
                markValidDigit(sb, digit.get());

            } else {
                markInvalidDigit(sb); // If we have only a 3-column set we can't match to a valid digit, we mark it as '?'
                isIll = true;
            }
        }

        // Append "ILL" if we had any '?' character
        if (isIll) {
            sb.append(" ILL");
        }

        return sb.toString();
    }
}
