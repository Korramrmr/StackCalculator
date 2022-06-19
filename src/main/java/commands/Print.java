package commands;

import calculator.Command;
import calculator.CalculatorContext;
import calculator.CalculatorException;

public final class Print implements Command {
    @Override
    public void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException {
        System.out.println(calculatorContext.getStackNumbers().getFirst());
    }
}
