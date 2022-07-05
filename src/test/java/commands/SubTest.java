package commands;

import calculator.CalculatorException;
import calculator.Command;
import calculator.CommandFactory;
import org.junit.jupiter.api.Test;
import calculator.CalculatorContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SubTest {
    @Test

    public void commandAddWorkCorrect() {
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(400.0);
        contextTest.getStack().add(300.0);

        final Sub commandSub = new Sub();
        commandSub.calculate(null, contextTest);
        final double expectedResult = 100.0;

        assertEquals(expectedResult, contextTest.getStack().pop());
    }

    @Test
    public void commandSubIsEmpty(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandSub = factory.findNameCommand("-");

        assertThrows(CalculatorException.class, () -> commandSub.calculate(null, contextTest));
    }

    @Test
    public void inCommandSubNotEnoughArgs(){
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext contextTest = new CalculatorContext();

        final Command commandSub = factory.findNameCommand("-");
        contextTest.getStack().add(101.0);

        assertThrows(CalculatorException.class, () -> commandSub.calculate(null, contextTest));
    }


}