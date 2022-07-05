package commands;

import java.util.Deque;

import calculator.CalculatorException;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CommandRequirements;

public final class Add implements Command  {
    @Override
    @CommandRequirements(desiredStackSize = 2)
    public void calculate (final String[] args, final CalculatorContext context) throws CalculatorException {
        final Deque<Double> stackNumbers = context.getStack();
        final double firstNumber = stackNumbers.removeFirst();
        final double secondNumber = stackNumbers.removeFirst();
        stackNumbers.add(firstNumber + secondNumber);
    }


}
