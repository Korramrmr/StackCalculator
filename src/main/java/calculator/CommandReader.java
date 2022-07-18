package calculator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public final class CommandReader {

    private static final int COMMAND_INDEX = 0;

    public void parseCommand(final Io ioDelegate) throws CalculatorException, FileNotFoundException {
        final CalculatorContext context = new CalculatorContext();
        final CommandFactory factory = new CommandFactory();
        try (final Scanner scanner = ioDelegate.getSource()) {
            while (true) {
                ioDelegate.onNewLineProcessingStart();

                if (ioDelegate.doneProcessing(scanner)) {
                    break;
                } else {
                    final String stringScanner = ioDelegate.readLine(scanner);
                    final String[] scannerCommands = stringScanner.split(" ");

                    final Command command = factory.findNameCommand(scannerCommands[COMMAND_INDEX]);
                    assert command != null;
                    command.calculate(scannerCommands, context);
                }
            }
        }
    }
}


