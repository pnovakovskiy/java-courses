import java.util.Scanner;
import java.util.regex.*;

public class InteractRunner {
    private static final String REGEXP = "\\d+ (\\+|-|\\*|/|pow) \\d+";
    private static final String EXITCODE = "Exit";

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

    private double doCalculate(String exp) {
        double result = 0;

        Calculator calc = new Calculator();

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

        return result;
    }
    public static void main(String[] args) {
        String exp = "";
        double tmpResult = 0;

        System.out.println("Calculate...");
        System.out.println("Type 'Exit' to stop the programm.");

        try (Scanner sc = new Scanner(System.in)) {
            InteractRunner ir = new InteractRunner();

            for ( ; ; ) {
                System.out.println("Please, enter an expression in this format: a + b. Available operations are: +, -, *, /, pow.");
                exp = sc.nextLine();
                if (exp.equalsIgnoreCase(EXITCODE)) {
                    break;
                }

                if (!ir.checkExp(exp)) {
                    System.out.println("Invalid expression format.");
                    continue;
                }
                else {
                    double result = ir.doCalculate(exp);
                    System.out.println("Result of expression: " + result);
                }
            }
        }
        catch (PatternSyntaxException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
