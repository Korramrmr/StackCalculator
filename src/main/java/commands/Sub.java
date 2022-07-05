package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CommandRequirements;

public final class Sub implements Command {
    @Override
    @CommandRequirements(desiredStackSize = 2)
    public void calculate (final String[] args, final CalculatorContext context) {
        final Deque<Double> stackNumbers = context.getStack();
        double firstNumber = stackNumbers.removeFirst();
        double secondNumber = stackNumbers.removeFirst();
        stackNumbers.add(firstNumber - secondNumber);
    }
}

