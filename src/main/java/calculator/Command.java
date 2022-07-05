package calculator;

public interface Command {
     void calculate(final String[] args, final CalculatorContext context) throws CalculatorException;
}
