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
        CalculatorContext contextTest = new CalculatorContext();
        contextTest.getStackNumbers().add(222.0);

        Print commandPrint = new Print();
        commandPrint.calculate(null, contextTest);
        double expectedResult = 222.0;

        assertEquals(expectedResult, contextTest.getStackNumbers().getFirst());
    }

    @Test
    public void notEnoughArgs() {
        CalculatorContext calculatorContext = new CalculatorContext();

        Print commandPrint = new Print();

        assertThrows(NoSuchElementException.class, () -> commandPrint.calculate(null, calculatorContext));

    }


}