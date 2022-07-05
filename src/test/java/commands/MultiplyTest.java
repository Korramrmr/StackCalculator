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
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(333.0);
        contextTest.getStack().add(3.0);

        final Multiply commandMultiply = new Multiply();
        commandMultiply.calculate(null, contextTest);
        final double expectedResult = 999.0;

        assertEquals(expectedResult, contextTest.getStack().pop());
    }

    @Test
    public void commandMultiplyIsEmpty(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandMultiply = factory.findNameCommand("*");

        assertThrows(CalculatorException.class, () -> commandMultiply.calculate(null, contextTest));
    }

    @Test
    public void inCommandMultiplyNotEnoughArgs(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        contextTest.getStack().add(100.0);
        Command commandMultiply = factory.findNameCommand("*");

        assertThrows(CalculatorException.class, () -> commandMultiply.calculate(null, contextTest));
    }

}