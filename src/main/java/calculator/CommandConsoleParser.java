package calculator;

import java.util.Scanner;

public final class CommandConsoleParser {
    private static final String WELCOME = "Введите необходимые параметры. Для завершения введите EXIT";
    public static final String EXIT = "EXIT";
    public static final int COMMAND_INDEX = 0;


    public void readConsole() throws CalculatorException {
        final CalculatorContext calculatorContext = new CalculatorContext();
        final CommandFactory factory = new CommandFactory();

        boolean calculatorConsoleCheck = true;

        try(final Scanner scanner = new Scanner(System.in)) {
            while (calculatorConsoleCheck) {
                System.out.println(WELCOME);
                final String stringScanner = scanner.nextLine();
                if (EXIT.equalsIgnoreCase(stringScanner)) {
                    calculatorConsoleCheck = false;
                } else {
                    final String[] commandsFromConsole = stringScanner.split(" ");

                  final Command command = factory.findNameCommand(commandsFromConsole[COMMAND_INDEX]);
                  command.calculate(commandsFromConsole, calculatorContext);
                }
            }
        }
    }
}

