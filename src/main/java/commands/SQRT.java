package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.StackSize;

public final class SQRT implements Command {
    @Override
    @StackSize(valueStackSize = 1)
    public void calculate (final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        Deque<Double> stackNumbers = calculatorContext.getStackNumbers();
        double firstNumber = stackNumbers.removeFirst();
        if (firstNumber <= 0) {
            throw new CalculatorException("Число должно быть положительным. Невозможно извлечь квадратный корень из отрицательного числа.");
        }
        stackNumbers.add(Math.sqrt(firstNumber));
    }
}
