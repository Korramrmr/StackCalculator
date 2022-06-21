package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;

import static constants.Constant.*;

public final class Define implements Command {

    @Override
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        calculatorContext.getCommandAndValue().put(args[INDEX_ARG_DEFINE], Double.valueOf(args[INDEX_ARG_DEFINE_NUMBER]));
    }
}
