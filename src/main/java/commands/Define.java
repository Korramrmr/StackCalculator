package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.StackSize;

public final class Define implements Command {
    @Override
    @StackSize(valueStackSize = 3)
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        calculatorContext.getCommandAndValue().put(args[1], Double.valueOf(args[2]));
    }
}
