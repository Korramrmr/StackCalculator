package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;

public final class Push implements Command {
    @Override
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        if (Character.isAlphabetic(args[1].charAt(0))){
            calculatorContext.getStackNumbers().add(calculatorContext.getCommandAndValue().get(args[1]));
        } else {
            calculatorContext.getStackNumbers().add(Double.valueOf(args[1]));
        }    }
}
