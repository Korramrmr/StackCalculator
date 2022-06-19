package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.Command;
import calculator.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

    @Test
    public void commandMultiplyWorkCorrect() {
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(333.0);
        contextTest.getStackNumbers().add(3.0);

        Multiply commandMultiply = new Multiply();
        commandMultiply.calculate(null, contextTest);
        final double expectedResult = 999.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().pop());
    }

    @Test
    public void commandMultiplyIsEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandMultiply = factory.findNameCommand("*");

        assertThrows(CalculatorException.class, () -> commandMultiply.calculate(null, contextTest));
    }

    @Test
    public void inCommandMultiplyNotEnoughArgs(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        contextTest.getStackNumbers().add(100.0);
        Command commandMultiply = factory.findNameCommand("*");

        assertThrows(CalculatorException.class, () -> commandMultiply.calculate(null, contextTest));
    }

}