package calculator;

import java.io.*;
import java.util.Scanner;
import static constants.Constant.*;

public final class CommandFileReader  {

    public void executeFile(String inFileName) throws FileNotFoundException, CalculatorException {
        final CalculatorContext calculatorContext = new CalculatorContext();
        if (inFileName != null) {
            final CommandFactory factory = CommandFactory.getInstance();
            try(final Scanner scanner = new Scanner(new File(inFileName));) {
                while (scanner.hasNextLine()) {
                    final String stringScanner = scanner.nextLine();
                    final String[] argsCommands = stringScanner.split(" ");
                    final Command command = factory.findNameCommand(argsCommands[COMMAND_INDEX]);
                    if (command == null) {
                        System.out.println("Команда не найдена");
                    }
                    command.calculate(argsCommands, calculatorContext);
                }
            }
        } else {
            System.out.println("Файл не найден");
        }
    }
}



