package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.CommandRequirements;

public final class Print implements Command {
    @Override
    @CommandRequirements(desiredStackSize = 1)
    public void calculate(final String[] args, final CalculatorContext context) throws CalculatorException {
        System.out.println(context.getStack().getFirst());
    }
}
