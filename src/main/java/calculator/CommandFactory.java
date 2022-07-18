package calculator;

import main.Main;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;


public final class CommandFactory {

    private static final String COMMAND_PATH = "/command.properties";
    private static final Command COMMAND_NOT_FOUND = (args, calculatorContext) -> System.out.println("Команда не найдена. Введите \"#\" чтобы посмотреть доступные команды");

    private final Map<String, Command> commandHashMap = new HashMap<>();

    public CommandFactory() {

        try (final InputStream input = Main.class.getResourceAsStream(COMMAND_PATH)) {
            final Properties commandProperties = new Properties();
            commandProperties.load(input);

            for (String nameCommand : commandProperties.stringPropertyNames()) {
                final String commandClassName = commandProperties.getProperty(nameCommand);
                final Class<?> commandClass = Class.forName(commandClassName);
                var executeCommand = (Command) Class.forName(commandClassName).getDeclaredConstructor().newInstance();
                CommandRequirements stackSize = commandClass.getMethod("calculate", String[].class, CalculatorContext.class).getAnnotation(CommandRequirements.class);


                final Command command = (args, calculatorContext) -> {
                    if (stackSize != null && stackSize.desiredStackSize() > calculatorContext.getStack().size()) {
                        throw new CalculatorException("Данная команда ожидает количество элементов: " + stackSize.desiredStackSize());
                    }
                    executeCommand.calculate(args, calculatorContext);
                };
                commandHashMap.put(nameCommand, command);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public Command findNameCommand(final String name) {
        return commandHashMap.getOrDefault(name.toUpperCase(Locale.ROOT), COMMAND_NOT_FOUND);
    }

}



