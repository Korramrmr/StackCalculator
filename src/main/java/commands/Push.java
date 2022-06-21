package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;

import java.util.Deque;

import static constants.Constant.*;

public final class Push implements Command {
    @Override
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        final Deque<Double> stackNumbers = calculatorContext.getStackNumbers();
        if (calculatorContext.getCommandAndValue().containsKey(args[ARG_INDEX_NUMBER])) {
            stackNumbers.push(calculatorContext.getCommandAndValue().get(args[ARG_INDEX_NUMBER]));
        } else {
            try {
                stackNumbers.push(Double.valueOf(args[ARG_INDEX_NUMBER]));
            } catch (final NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Параметр " + args[ARG_INDEX_NUMBER] + " не найден. Нужно ввести число.");
            }
        }
    }
}
