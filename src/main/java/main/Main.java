package main;

import calculator.*;

import java.io.FileNotFoundException;

public final class Main {
    private static final int MAX_INPUT_ARGS_INDEX = 1;
    private static final int FILE_NAME_ARG_INDEX = 0;

    private Main() {
        throw new UnsupportedOperationException("не вызывать через рефлексию");
    }

    public static void main(final String[] args) throws CalculatorException, FileNotFoundException {

        if (args.length > MAX_INPUT_ARGS_INDEX) {
            throw new CalculatorException("Неверное число аргументов. Файл для чтения должен быть один");
        }

        Io io = args.length == MAX_INPUT_ARGS_INDEX
                ? new FileIo(args[FILE_NAME_ARG_INDEX])
                : new ConsoleIo();

        final CommandReader reader = new CommandReader();
        reader.parseCommand(io);


    }
}
