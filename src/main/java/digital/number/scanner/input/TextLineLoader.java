package digital.number.scanner.input;

import digital.number.scanner.parsing.Line;
import digital.number.scanner.exceptions.FileParsingException;
import digital.number.scanner.exceptions.ParsingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextLineLoader implements LineLoader {

    private final String fileName;
    private final Charset encoding;

    public TextLineLoader(String fileName, Charset encoding) {
        this.fileName = fileName;
        this.encoding = encoding;
    }

    public TextLineLoader(String fileName) {
        this(fileName, StandardCharsets.UTF_8);
    }

    public List<Line> loadLines() throws FileParsingException, ParsingException {

        List<Line> lines = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, encoding)) {

            String line1 = null;
            String line2 = null;
            String line3 = null;

            String currentLine = br.readLine();
            while (currentLine != null) {

                if (!currentLine.isEmpty()) {

                    // Build a group of 3 lines
                    if (line1 == null) {
                        line1 = currentLine;
                    } else if (line2 == null) {
                        line2 = currentLine;
                    } else {
                        line3 = currentLine;
                    }

                    // Once a group of 3 lines is built, put them in an object and clear the group
                    if (line2 != null && line3 != null) {
                        lines.add(new Line(line1, line2, line3));

                        // Clear the group
                        line1 = null;
                        line2 = null;
                        line3 = null;
                    }
                }
                currentLine = br.readLine();
            }

        } catch (IOException ioe) {
            throw new FileParsingException(String.format("Could not read the file '%s'", fileName), ioe);
        }

        return lines;
    }
}
