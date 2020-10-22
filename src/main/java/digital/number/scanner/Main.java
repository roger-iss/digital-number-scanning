package digital.number.scanner;

import digital.number.scanner.input.LineLoader;
import digital.number.scanner.input.TextLineLoader;
import digital.number.scanner.output.ConsoleNumberDisplayer;
import digital.number.scanner.output.NumberDisplayer;

public class Main {
    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Please specify the file path");
        }
        String fileName = args[0];

        // Inject dependencies (usually we would use Spring to do that)
        LineLoader lineLoader = new TextLineLoader(fileName);
        NumberDisplayer numberDisplayer = new ConsoleNumberDisplayer();

        // Run the app
        Scanner scanner = new Scanner(lineLoader, numberDisplayer);
        scanner.scan();
    }

}
