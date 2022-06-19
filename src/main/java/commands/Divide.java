package commands;

import java.util.Deque;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.StackSize;

public final class Divide implements Command {
    @Override
    @StackSize(valueStackSize = 2)
    public void calculate (final String[] args, final CalculatorContext calculatorContext) {
        Deque<Double> stackNumbers = calculatorContext.getStackNumbers();
        double firstNumber = stackNumbers.removeFirst();
        double secondNumber = stackNumbers.removeFirst();
        stackNumbers.add(firstNumber / secondNumber);
    }
}
