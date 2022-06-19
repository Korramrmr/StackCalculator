package commands;

import java.util.Deque;

import calculator.CalculatorException;
import calculator.Command;
import calculator.CalculatorContext;
import calculator.StackSize;

public final class Add implements Command  {
    @Override
    @StackSize(valueStackSize = 2)
    public void calculate (final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        Deque<Double> stackNumbers = calculatorContext.getStackNumbers();
        double firstNumber = stackNumbers.removeFirst();
        double secondNumber = stackNumbers.removeFirst();
        stackNumbers.add(firstNumber + secondNumber);
    }


}