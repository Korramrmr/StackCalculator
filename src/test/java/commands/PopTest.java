package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import commands.Divide;
import commands.Pop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    @Test
    public void commandPopWorkCorrect() throws CalculatorException {
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(222.0);
        contextTest.getStackNumbers().add(333.0);

        Pop commandPop = new Pop();
        commandPop.calculate(null, contextTest);
        double expectedResult = 333.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().pop());
    }

}