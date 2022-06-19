package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CommandFactoryTest {

    @Test
    public void commandFactoryWorkCorrect() throws CalculatorException {
        String[] testArrayCommandPush = {"PUSH", "100"};
        CalculatorContext calculatorContext = new CalculatorContext();
        CommandFactory factory = CommandFactory.getInstance();

        factory.findNameCommand(testArrayCommandPush[0]).calculate(testArrayCommandPush,calculatorContext);

        Assertions.assertEquals(Double.valueOf(testArrayCommandPush[1]), calculatorContext.getStackNumbers().getLast());

        String[] testArrayCommandSQRT = {"SQRT"};
        factory.findNameCommand(testArrayCommandSQRT[0]).calculate(testArrayCommandSQRT, calculatorContext);

        Assertions.assertEquals(Double.valueOf(10), calculatorContext.getStackNumbers().getLast());

    }

}