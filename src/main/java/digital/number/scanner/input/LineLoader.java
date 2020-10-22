package digital.number.scanner.input;

import digital.number.scanner.parsing.Line;
import digital.number.scanner.exceptions.FileParsingException;
import digital.number.scanner.exceptions.ParsingException;

import java.util.List;

public interface LineLoader {
    List<Line> loadLines() throws FileParsingException, ParsingException;
}
