package calculator;

import main.Main;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import static constants.Constant.*;


public final class CommandFactory {

    private static final CommandFactory factory = new CommandFactory();

    private final HashMap<String, Command> commandHashMap = new HashMap<>();

    public static CommandFactory getInstance() {
        return factory;
    }

    private CommandFactory()  {

        try(final InputStream input = Main.class.getResourceAsStream(COMMAND_PATH)){
            final Properties commandProperties = new Properties();
            commandProperties.load(input);

            for (String nameCommand: commandProperties.stringPropertyNames()){
                final String commandClassName = commandProperties.getProperty(nameCommand);
                Class<?> commandClass = Class.forName(commandClassName);
                var executeCommand = (Command) Class.forName(commandClassName).getDeclaredConstructor().newInstance();
                StackSize stackSize =  commandClass.getMethod("calculate", String[].class, CalculatorContext.class).getAnnotation(StackSize.class);


                final Command command = (args, calculatorContext) -> {
                    if (stackSize != null && stackSize.valueStackSize() > calculatorContext.getStackNumbers().size()){
                     throw new CalculatorException("Данная команда ожидает количество элементов: " + stackSize.valueStackSize());
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



