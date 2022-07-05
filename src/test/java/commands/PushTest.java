package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    public void commandPushWorkCorrect() throws CalculatorException {
        final CalculatorContext contextTest = new CalculatorContext();
        final String[] testArrayCommand = {"push", "333.0"};

        final Push commandPush = new Push();
        commandPush.calculate(testArrayCommand, contextTest);

        final double expectedResult = 333.0;

        assertEquals(expectedResult, contextTest.getStack().getFirst());
    }

}