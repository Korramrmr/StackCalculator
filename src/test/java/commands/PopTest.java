package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    @Test
    public void commandPopWorkCorrect() throws CalculatorException {
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(222.0);
        contextTest.getStack().add(333.0);

        final Pop commandPop = new Pop();
        commandPop.calculate(null, contextTest);
        final double expectedResult = 333.0;

        assertEquals(expectedResult, contextTest.getStack().pop());
    }

}