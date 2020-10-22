package digital.number.scanner;

import digital.number.scanner.exceptions.FileParsingException;
import digital.number.scanner.exceptions.ParsingException;
import digital.number.scanner.input.LineLoader;
import digital.number.scanner.output.NumberDisplayer;
import digital.number.scanner.parsing.Line;

import java.util.List;

public class Scanner {

    private final LineLoader lineLoader;
    private final NumberDisplayer numberDisplayer;

    public Scanner(LineLoader lineLoader, NumberDisplayer numberDisplayer) {
        this.lineLoader = lineLoader;
        this.numberDisplayer = numberDisplayer;
    }

    public void scan() {

        try {
            // Load the lines of numbers
            final List<Line> lines = lineLoader.loadLines();

            // Build the "toString" and display it
            lines.forEach(l -> numberDisplayer.display(l.toString()));

        } catch (FileParsingException | ParsingException e) {
            // If any error, we display them at the same place as where the numbers are expected
            numberDisplayer.display(e.getMessage());
        }
    }

}
