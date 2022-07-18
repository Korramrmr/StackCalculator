package main;

import calculator.*;

import java.io.FileNotFoundException;

public final class Main {
    private static final int MAX_INPUT_ARGS_INDEX = 1;
    private static final int FILE_NAME_ARG_INDEX = 0;

    private Main() {
    }

    public static void main(final String[] args) throws CalculatorException, FileNotFoundException {

        if (args.length > MAX_INPUT_ARGS_INDEX) {
            throw new CalculatorException("Неверное число аргументов. Файл для чтения должен быть один");
        } else if (args.length == MAX_INPUT_ARGS_INDEX) {
            final FileIo fileIo = new FileIo(args[FILE_NAME_ARG_INDEX]);
            final CommandReader readerFromFile = new CommandReader();
            readerFromFile.parseCommand(fileIo);
        } else {
            final ConsoleIo consoleIo = new ConsoleIo();
            final CommandReader readerFromConsole = new CommandReader();
            readerFromConsole.parseCommand(consoleIo);
        }

    }
}
