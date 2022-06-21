package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    public void commandPushWorkCorrect() throws CalculatorException {
        CalculatorContext contextTest = new CalculatorContext();
        String[] testArrayCommand = {"push", "333.0"};

        Push commandPush = new Push();
        commandPush.calculate(testArrayCommand, contextTest);

        double expectedResult = 333.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().getFirst());
    }

}