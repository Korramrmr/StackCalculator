package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CommandRequirements;

public final class Divide implements Command {
    @Override
    @CommandRequirements(desiredStackSize = 2)
    public void calculate (final String[] args, final CalculatorContext context) {
        final Deque<Double> stackNumbers = context.getStack();
        final double leftOperand = stackNumbers.removeFirst();
        final double rightOperand = stackNumbers.removeFirst();
        stackNumbers.add(leftOperand / rightOperand);
    }
}
