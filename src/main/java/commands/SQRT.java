package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.CommandRequirements;

public final class SQRT implements Command {
    @Override
    @CommandRequirements(desiredStackSize = 1)
    public void calculate (final String[] args, final CalculatorContext context) throws CalculatorException {
        final Deque<Double> stackNumbers = context.getStack();
        final double firstNumber = stackNumbers.removeFirst();
        if (firstNumber <= 0) {
            throw new CalculatorException("Число должно быть положительным. Невозможно извлечь квадратный корень из отрицательного числа.");
        }
        stackNumbers.add(Math.sqrt(firstNumber));
    }
}
