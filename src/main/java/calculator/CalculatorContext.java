package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public final class CalculatorContext {
    private final Deque<Double> stackNumbers = new ArrayDeque<>();
    private final HashMap<String, Double> commandAndValue = new HashMap<>();

    public Deque<Double> getStackNumbers() {
        return stackNumbers;
    }

    public HashMap<String, Double> getCommandAndValue() {
        return commandAndValue;
    }
}
