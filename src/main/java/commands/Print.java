package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.StackSize;

public final class Print implements Command {
    @Override
    @StackSize(valueStackSize = 1)
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        System.out.println(calculatorContext.getStackNumbers().getFirst());
    }
}
