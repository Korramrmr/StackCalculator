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
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(101.0);
        contextTest.getStack().add(303.0);

        final Add commandAdd = new Add();
        commandAdd.calculate(null, contextTest);
        final double expectedResult = 404.0;

        assertEquals(expectedResult, contextTest.getStack().pop());
    }

    @Test
    public void commandAddIsEmpty(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandAdd = factory.findNameCommand("+");

        assertThrows(CalculatorException.class, () -> commandAdd.calculate(null, contextTest));
    }

    @Test
    public void inCommandAddNotEnoughArgs(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandAdd = factory.findNameCommand("+");
        contextTest.getStack().add(101.0);

        assertThrows(CalculatorException.class, () -> commandAdd.calculate(null, contextTest));
    }

}