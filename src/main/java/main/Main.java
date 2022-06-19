package main;

import calculator.CalculatorException;
import calculator.CommandFileReader;
import calculator.CommandConsoleParser;
import static constants.Constant.*;


import java.io.FileNotFoundException;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws CalculatorException, FileNotFoundException {

        if (args.length > MAX_INPUT_ARGS_INDEX) {
            throw new CalculatorException("Неверное число аргументов. Файл для чтения должен быть один");
        }
        else if (args.length == MAX_INPUT_ARGS_INDEX) {
            final CommandFileReader commandFileReader = new CommandFileReader();
            commandFileReader.executeFile(args[FILE_NAME_ARG_INDEX]);
        }
        else {
            final CommandConsoleParser commandConsoleParser = new CommandConsoleParser();
            commandConsoleParser.readConsole();
        }

    }
}
