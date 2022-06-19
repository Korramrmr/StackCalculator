package calculator;

import java.util.Scanner;
import static constants.Constant.*;

public final class CommandConsoleParser {

    public void readConsole() throws CalculatorException {
        final CalculatorContext calculatorContext = new CalculatorContext();
        final CommandFactory factory = CommandFactory.getInstance();

        boolean calculatorConsoleCheck = true;

        try(final Scanner scanner = new Scanner(System.in)) {
            while (calculatorConsoleCheck) {
                System.out.println(WELCOME);
                final String stringScanner = scanner.nextLine();
                if (EXIT.equalsIgnoreCase(stringScanner)) {
                    calculatorConsoleCheck = false;
                } else {
                    String[] commandsFromConsole = stringScanner.split(" ");

                  final Command command = factory.findNameCommand(commandsFromConsole[COMMAND_INDEX]);
                  command.calculate(commandsFromConsole, calculatorContext);
                }
            }
        }
    }
}

