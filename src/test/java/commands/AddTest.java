package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.Command;
import calculator.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddTest {
    @Test
    public void commandAddWorkCorrect() throws CalculatorException {
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(101.0);
        contextTest.getStackNumbers().add(303.0);

        Add commandAdd = new Add();
        commandAdd.calculate(null, contextTest);
        double expectedResult = 404.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().pop());
    }

    @Test
    public void commandAddIsEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandAdd = factory.findNameCommand("+");

        assertThrows(CalculatorException.class, () -> commandAdd.calculate(null, contextTest));
    }

    @Test
    public void inCommandAddNotEnoughArgs(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandAdd = factory.findNameCommand("+");
        contextTest.getStackNumbers().add(101.0);

        assertThrows(CalculatorException.class, () -> commandAdd.calculate(null, contextTest));
    }

}