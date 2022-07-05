package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public final class CalculatorContext {
    private final Deque<Double> stack = new ArrayDeque<>();
    private final HashMap<String, Double> commandAndValue = new HashMap<>();

    public Deque<Double> getStack() {
        return stack;
    }

    public HashMap<String, Double> getCommandAndValue() {
        return commandAndValue;
    }
}
