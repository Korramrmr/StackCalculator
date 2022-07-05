package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;


public final class Define implements Command {
    private static final int INDEX_ARG_DEFINE = 1;
    private static final int INDEX_ARG_DEFINE_NUMBER = 2;

    @Override
    public void calculate(final String[] args, final CalculatorContext context) throws CalculatorException {
        context.getCommandAndValue().put(args[INDEX_ARG_DEFINE], Double.valueOf(args[INDEX_ARG_DEFINE_NUMBER]));
    }
}
