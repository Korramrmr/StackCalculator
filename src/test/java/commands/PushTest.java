package commands;

import calculator.CalculatorContext;
import calculator.CalculatorException;
import commands.Push;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    public void commandPushWorkCorrect() throws CalculatorException {
        CalculatorContext contextTest = new CalculatorContext();
        Push commandPush = new Push();
        contextTest.getStackNumbers().add(101.0);
    }

}