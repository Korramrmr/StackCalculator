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
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(100.0);

        SQRT commandSQRT = new SQRT();
        commandSQRT.calculate(null, contextTest);
        double expectedResult = 10.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().pop());
    }

    @Test
    public void commandSQRTThrowsCalculatorException() {
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(-100.0);
        SQRT commandSQRT = new SQRT();

        assertThrows(CalculatorException.class, () -> commandSQRT.calculate(null, contextTest));
    }

    @Test
    public void commandSQRTIsEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandSQRT = factory.findNameCommand("SQRT");

        assertThrows(CalculatorException.class, () -> commandSQRT.calculate(null, contextTest));
    }

}