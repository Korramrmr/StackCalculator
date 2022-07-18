package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CommandFactoryTest {

    @Test
    public void commandFactoryWorkCorrect() throws CalculatorException {
        final String[] testArrayCommandPush = {"PUSH", "100"};
        final CalculatorContext context = new CalculatorContext();
        final CommandFactory factory = new CommandFactory();

        factory.findNameCommand(testArrayCommandPush[0]).calculate(testArrayCommandPush,context);

        Assertions.assertEquals(Double.valueOf(testArrayCommandPush[1]), context.getStack().getLast());

        final String[] testArrayCommandSQRT = {"SQRT"};
        factory.findNameCommand(testArrayCommandSQRT[0]).calculate(testArrayCommandSQRT, context);

        Assertions.assertEquals(Double.valueOf(10), context.getStack().getLast());

    }

}