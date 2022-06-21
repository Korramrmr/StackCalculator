package constants;

import calculator.Command;

public class Constant {
    public static final String WELCOME = "Введите необходимые параметры. Для завершения введите EXIT";
    public static final String EXIT = "EXIT";
    public static final int COMMAND_INDEX = 0;
    public static final String COMMAND_PATH = "/command.properties";
    public static final int MAX_INPUT_ARGS_INDEX = 1;
    public static final int FILE_NAME_ARG_INDEX = 0;
    public static final int ARG_INDEX_NUMBER = 1;
    public static final int INDEX_ARG_DEFINE = 1;
    public static final int INDEX_ARG_DEFINE_NUMBER = 2;
    public static final Command COMMAND_NOT_FOUND = (args, calculatorContext) -> System.out.println("Команда не найдена. Введите \"#\" чтобы посмотреть доступные команды");



}
