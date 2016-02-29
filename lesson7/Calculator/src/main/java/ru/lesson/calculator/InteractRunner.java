package ru.lesson.calculator;

import java.util.Scanner;
import java.util.regex.*;

public class InteractRunner {
    private ExpressionChecker expressionChecker;

    private final Scanner scanner;

    private Calculator calculator;

    /**
     * Константа, описывающая шаблон вводимого пользователем выражения
     */
    private final String REG_EXP = "\\-?\\d+(\\.\\d{0,})? (\\+|-|\\*|/|pow) \\-?\\d+(\\.\\d{0,})?";

    /**
     * Константа. Содержит текст, который необходимо ввести пользователю для выхода из программы
     */
    private final String EXIT_CODE = "Exit";

    /**
     * Константа. Содержит текст, который необходимо ввести пользователю для использования результата
     * предыдущей операции
     */
    private final String USE_CURR_RESULT_CODE = "Yes";

    /**
     * Конструктор класса
     */
    public InteractRunner(final Scanner scanner, final Calculator calculator) {
        expressionChecker = new ExpressionChecker();
        expressionChecker.setTemplate(REG_EXP);
        this.scanner = scanner;
        this.calculator = calculator;
        System.out.println("Type 'Exit' to stop the program.");
        System.out.println("Available operations are: +, -, *, /, pow.");
        runExec();
    }

    /**
     * Получем операнды и операцию, вычисляем выражение
     * @param exp выражение
     */
    public void doCalculate(final String exp) {
        ExpressionParser expressionParser = new ExpressionParser(exp);
        expressionParser.parse();

        switch (expressionParser.getOperation()) {
            case "+":
                calculator.add(expressionParser.getOperand1(), expressionParser.getOperand2());
                break;
            case "-":
                calculator.subtrac(expressionParser.getOperand1(), expressionParser.getOperand2());
                break;
            case "*":
                calculator.multiply(expressionParser.getOperand1(), expressionParser.getOperand2());
                break;
            case "/":
                calculator.divide(expressionParser.getOperand1(), expressionParser.getOperand2());
                break;
            case "pow":
                calculator.pow(expressionParser.getOperand1(), expressionParser.getOperand2());
                break;
        }
    }

    /**
     * Запускает работу класса
     */
    private void runExec() {
        String exp;
        String expTmp;
        boolean usePrevResult = false;
        double result = 0;

        for (; ; ) {
            System.out.println(usePrevResult ? "Enter an expression without leading space in this format: + b to use previous operation result." : "Enter an expression in this format: a + b.");
            expTmp = scanner.nextLine();
            if (expTmp.equalsIgnoreCase(EXIT_CODE)) {
                break;
            }
            exp = (usePrevResult) ? (result + " " + expTmp) : expTmp;
            expressionChecker.setExpression(exp);
            try {
                if (!expressionChecker.checkExp()) {
                    System.out.println("Invalid expression format.");
                } else {
                    doCalculate(exp);
                    result = calculator.getResult();
                    calculator.cleanResult();
                    System.out.println("Result of expression: " + result);
                    System.out.println("Do you want to use current result in next expression? (yes/no):");
                    expTmp = scanner.nextLine();
                    usePrevResult = expTmp.equalsIgnoreCase(USE_CURR_RESULT_CODE);
                }
            } catch (PatternSyntaxException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new InteractRunner(new Scanner(System.in), new Calculator());
    }
}
