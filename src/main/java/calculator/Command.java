package calculator;

public interface Command {
     void calculate(final String[] args, final CalculatorContext calculatorContext) throws CalculatorException;
}
