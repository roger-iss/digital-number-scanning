package digital.number.scanner.output;

public class ConsoleNumberDisplayer implements NumberDisplayer {

    @Override
    public void display(String value) {
        System.out.println(value);
    }
}
