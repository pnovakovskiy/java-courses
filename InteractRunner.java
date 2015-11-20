import java.util.Scanner;
import java.util.regex.*;

public class InteractRunner {
    private final String REGEXP = "\\-?\\d+(\\.\\d{0,})? (\\+|-|\\*|/|pow) \\-?\\d+(\\.\\d{0,})?";
    private final String EXITCODE = "Exit";
    private final String USECURRRESULTCODE = "Yes";

    /**
     * Проверяет введенное пользователем выражение на соответствие шаблону
     * @param exp выражение
     * @return true or false
     * @throws PatternSyntaxException
     */
    private boolean checkExp(String exp) throws PatternSyntaxException {
        Pattern p = Pattern.compile(REGEXP);
        Matcher m = p.matcher(exp);
        return m.matches();
    }

    /**
     * Получем операнды и операцию, вычисляем выражение
     * @param exp выражение
     */
    private void doCalculate(String exp, Calculator calc) {
        double result = 0;

        try {
            double operandFirst = Double.parseDouble(exp.substring(0, exp.indexOf(" ")));
            String operation = exp.substring(exp.indexOf(" ") + 1, exp.lastIndexOf(" "));
            double operandSecond = Double.parseDouble(exp.substring(exp.lastIndexOf(" ") + 1, exp.length()));

            switch (operation) {
                case "+":
                    calc.add(operandFirst, operandSecond);
                    break;
                case "-":
                    calc.subtrac(operandFirst, operandSecond);
                    break;
                case "*":
                    calc.multiply(operandFirst, operandSecond);
                    break;
                case "/":
                    calc.divide(operandFirst, operandSecond);
                    break;
                case "pow":
                    calc.pow(operandFirst, operandSecond);
                    break;
            }
            result = calc.getResult();
        }
        catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException  exc) {
            System.out.println(exc.getMessage());
        }
    }
    public static void main(String[] args) {
        String exp = "", expTmp = "";
        double result = 0;
        boolean usePrevOperResult = false;

        System.out.println("Calculate...");
        System.out.println("Type 'Exit' to stop the programm.");

        Calculator calc = new Calculator();

        try (Scanner sc = new Scanner(System.in)) {
            InteractRunner ir = new InteractRunner();

            for ( ; ; ) {
                if (usePrevOperResult) {
                    System.out.println("Please, enter an expression without leading space in this format: + b to use previous operation result. Available operations are: +, -, *, /, pow:");
                }
                else {
                    System.out.println("Please, enter an expression in this format: a + b. Available operations are: +, -, *, /, pow:");
                }
                expTmp = sc.nextLine();
                exp = (usePrevOperResult) ? (result + " " + expTmp) : expTmp;
                if (expTmp.equalsIgnoreCase(ir.EXITCODE)) {
                    break;
                }

                if (!ir.checkExp(exp)) {
                    System.out.println("Invalid expression format.");
                    continue;
                }
                else {
                    ir.doCalculate(exp, calc);
                    result = calc.getResult();
                    calc.cleanResult();
                    System.out.println("Result of expression: " + result);

                    System.out.println("Do you want to use current result in next expression? (yes/no):");
                    expTmp = sc.nextLine();

                    usePrevOperResult = (expTmp.equalsIgnoreCase(ir.USECURRRESULTCODE)) ? true : false;
                }
            }
        }
        catch (PatternSyntaxException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
