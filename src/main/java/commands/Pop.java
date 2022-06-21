package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.StackSize;

public final class Pop implements Command {
    @Override
    @StackSize(valueStackSize = 1)
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        final Deque<Double> stackNumbers = calculatorContext.getStackNumbers();
        stackNumbers.pop();
    }
}
