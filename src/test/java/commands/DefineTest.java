package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.Command;
import calculator.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    @Test
    public void commandDefineWorkCorrect() throws CalculatorException {
        final CommandFactory factory = new CommandFactory();
        final CalculatorContext context = new CalculatorContext();
        final String[] args = {"Define", "a", "100"};
        final Command commandDefine = factory.findNameCommand("DEFINE");
        final Command push = factory.findNameCommand("PUSH");
        commandDefine.calculate(args, context);
        push.calculate(args, context);
        assertEquals(100, context.getStack().pop());
    }

}