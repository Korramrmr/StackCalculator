package commands;


import calculator.CalculatorContext;
import calculator.CalculatorException;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrintTest {

    @Test
    public void commandPrintWorkCorrect() throws CalculatorException {
        final CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStack().add(222.0);

        final Print commandPrint = new Print();
        commandPrint.calculate(null, contextTest);
        final double expectedResult = 222.0;

        assertEquals(expectedResult, contextTest.getStack().getFirst());
    }

    @Test
    public void notEnoughArgs() {
        final CalculatorContext calculatorContext = new CalculatorContext();

        final Print commandPrint = new Print();

        assertThrows(NoSuchElementException.class, () -> commandPrint.calculate(null, calculatorContext));

    }


}