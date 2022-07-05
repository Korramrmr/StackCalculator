package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;


class CalculatorContextTest {

    @Test
    public void getterGetStackIsEmpty()  {
        final CalculatorContext context = new CalculatorContext();
        Assertions.assertTrue(context.getStack().isEmpty());
    }

    @Test
    public void getterGetCommandAndValueIsEmpty()  {
        final CalculatorContext context = new CalculatorContext();
        Assertions.assertTrue(context.getCommandAndValue().isEmpty());
    }

    @Test
    public void getterGetCommandAndValueReturnCorrectMap() {
        final CalculatorContext context = new CalculatorContext();
        final HashMap<String, Double> commandAndValue = context.getCommandAndValue();
        commandAndValue.put("Push", 5.0);

        assertTrue(context.getCommandAndValue().containsKey("Push"));
        assertTrue(context.getCommandAndValue().containsValue(5.0));
    }

    @Test
    public void getterGetStackReturnCorrectStack() {
        final CalculatorContext context = new CalculatorContext();
        final var testStack = context.getStack();
        testStack.add(10.0);

        assertTrue(context.getStack().contains(10.0));
    }

}