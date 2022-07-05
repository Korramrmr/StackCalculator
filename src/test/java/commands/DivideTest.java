package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.Command;
import calculator.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    public void commandDivideWorkCorrect() {
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(222.0);
        contextTest.getStack().add(2.0);

        final Divide commandDivide = new Divide();
        commandDivide.calculate(null, contextTest);
        final double expectedResult = 111.0;

        assertEquals(expectedResult, contextTest.getStack().pop());
    }

    @Test
    public void commandDivideIsEmpty(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandDivide = factory.findNameCommand("/");


        assertThrows(CalculatorException.class, () -> commandDivide.calculate(null, contextTest));
    }

    @Test
    public void inCommandDivideNotEnoughArgs(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        contextTest.getStack().add(100.0);
        final Command commandDivide = factory.findNameCommand("/");

        assertThrows(CalculatorException.class, () -> commandDivide.calculate(null, contextTest));
    }



}