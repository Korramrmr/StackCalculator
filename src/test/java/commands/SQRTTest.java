package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.Command;
import calculator.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SQRTTest {
    @Test
    public void commandSQRTWorkCorrect() throws CalculatorException {
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(100.0);

        final SQRT commandSQRT = new SQRT();
        commandSQRT.calculate(null, contextTest);
        final double expectedResult = 10.0;

        assertEquals(expectedResult, contextTest.getStack().pop());
    }

    @Test
    public void commandSQRTThrowsCalculatorException() {
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(-100.0);
        final SQRT commandSQRT = new SQRT();

        assertThrows(CalculatorException.class, () -> commandSQRT.calculate(null, contextTest));
    }

    @Test
    public void commandSQRTIsEmpty(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandSQRT = factory.findNameCommand("SQRT");

        assertThrows(CalculatorException.class, () -> commandSQRT.calculate(null, contextTest));
    }

}