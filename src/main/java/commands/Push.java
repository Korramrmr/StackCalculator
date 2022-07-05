package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;

import java.util.Deque;


public final class Push implements Command {
    private static final int ARG_INDEX_NUMBER = 1;


    @Override
    public void calculate(final String[] args, final CalculatorContext context) throws CalculatorException {
        final Deque<Double> stackNumbers = context.getStack();
        if (context.getCommandAndValue().containsKey(args[ARG_INDEX_NUMBER])) {
            stackNumbers.push(context.getCommandAndValue().get(args[ARG_INDEX_NUMBER]));
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
