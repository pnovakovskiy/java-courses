package ru.lesson.calculator;

/**
 * Класс, реализующий разбиение выражения на операнды и операцию
 */
public class ExpressionParser {
    /**
     * Выражение
     */
    private String expression;

    /**
     * Первый операнд
     */
    private double operand1;

    /**
     * Второй операнд
     */
    private double operand2;

    /**
     * Операция
     */
    private String operation;

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public String getOperation() {
        return operation;
    }

    /**
     * Разбивает выражение на составляющие
     */
    public void parse() {
        try {
            this.operand1 = Double.parseDouble(expression.substring(0, expression.indexOf(" ")));
            this.operation = expression.substring(expression.indexOf(" ") + 1, expression.lastIndexOf(" "));
            this.operand2 = Double.parseDouble(expression.substring(expression.lastIndexOf(" ") + 1, expression.length()));
        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public ExpressionParser(final String expression) {
        this.expression = expression;
    }
}
