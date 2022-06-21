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
        CommandFactory factory = CommandFactory.getInstance();
        CalculatorContext ctx = new CalculatorContext();
        String[] args = {"Define", "a", "100"};
        Command commandDefine = factory.findNameCommand("DEFINE");
        Command push = factory.findNameCommand("PUSH");
        commandDefine.calculate(args, ctx);
        push.calculate(args, ctx);
        assertEquals(100, ctx.getStackNumbers().pop());
    }

}