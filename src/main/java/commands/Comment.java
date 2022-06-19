package commands;


import calculator.CalculatorContext;
import calculator.CalculatorException;
import calculator.Command;

public final class Comment implements Command {
    @Override
    public void calculate(String[] args, CalculatorContext calculatorContext) throws CalculatorException {
        System.out.println("\t Все доступные команды:");
        System.out.println("\t\"PUSH\" - добавить число в стек");
        System.out.println("\t\"POP\" - удалить последний элемент из стека");
        System.out.println("\t\"PRINT\" - печать верхнего элемента стека (без удаления).");
        System.out.println("\t\"DEFINE\" - задать значение параметра. Используется в дальнейшем.");
        System.out.println("\t\"SQRT\" - квадратный корень из числа");
        System.out.println("\t\"Add\" - сложение");
        System.out.println("\t\"Sub\" - вычитание");
        System.out.println("\t\"Multiply\" - умножение");
        System.out.println("\t\"Divide\" - деление");
        System.out.println("\t\"EXIT\" - выход и завершение\n");
    }
}
