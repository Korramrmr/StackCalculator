package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.CommandRequirements;

public final class Pop implements Command {
    @Override
    @CommandRequirements(desiredStackSize = 1)
    public void calculate(final String[] args, final CalculatorContext context) throws CalculatorException {
        final Deque<Double> stackNumbers = context.getStack();
        stackNumbers.pop();
    }
}
