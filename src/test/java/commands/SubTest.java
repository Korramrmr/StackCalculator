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
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(400.0);
        contextTest.getStackNumbers().add(300.0);

        Sub commandSub = new Sub();
        commandSub.calculate(null, contextTest);
        double expectedResult = 100.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().pop());
    }

    @Test
    public void commandSubIsEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandSub = factory.findNameCommand("-");

        assertThrows(CalculatorException.class, () -> commandSub.calculate(null, contextTest));
    }

    @Test
    public void inCommandSubNotEnoughArgs(){
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext contextTest = new CalculatorContext();

        Command commandSub = factory.findNameCommand("-");
        contextTest.getStackNumbers().add(101.0);

        assertThrows(CalculatorException.class, () -> commandSub.calculate(null, contextTest));
    }


}