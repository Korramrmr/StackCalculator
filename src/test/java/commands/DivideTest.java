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
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(222.0);
        contextTest.getStackNumbers().add(2.0);

        Divide commandDivide = new Divide();
        commandDivide.calculate(null, contextTest);
        final double expectedResult = 111.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().pop());
    }

    @Test
    public void commandDivideIsEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandDivide = factory.findNameCommand("/");

        assertThrows(CalculatorException.class, () -> commandDivide.calculate(null, contextTest));
    }

    @Test
    public void inCommandDivideNotEnoughArgs(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        contextTest.getStackNumbers().add(100.0);
        Command commandDivide = factory.findNameCommand("/");

        assertThrows(CalculatorException.class, () -> commandDivide.calculate(null, contextTest));
    }



}