import java.util.Scanner;
import java.util.regex.*;

public class Calculate {
    private static final String REGEXP = "\\d+ (\\+|-|\\*|/|pow) \\d+";
    private static final String EXITCODE = "Exit";

    private static boolean checkExp(String exp) throws PatternSyntaxException {
        Pattern p = Pattern.compile(REGEXP);
        Matcher m = p.matcher(exp);
        return m.matches();
    }

    private static double doCalculate(String exp) {
        double result = 0;

        try {
            double operandFirst = Double.parseDouble(exp.substring(0, exp.indexOf(" ")));
            String operation = exp.substring(exp.indexOf(" ") + 1, exp.lastIndexOf(" "));
            double operandSecond = Double.parseDouble(exp.substring(exp.lastIndexOf(" ") + 1, exp.length()));

            switch (operation) {
                case "+":
                    result = operandFirst + operandSecond;
                    break;
                case "-":
                    result = operandFirst - operandSecond;
                    break;
                case "*":
                    result = operandFirst * operandSecond;
                    break;
                case "/":
                    result = operandFirst / operandSecond;
                    break;
                case "pow":
                    result = Math.pow(operandFirst, operandSecond);
                    break;
            }
        }
        catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException  exc) {
            System.out.println(exc.getMessage());
        }

        return result;
    }

    public static void main(String[] args) {
        String exp = "";
        System.out.println("Calculate...");
        System.out.println("Type 'Exit' to stop the programm.");
        Scanner sc = new Scanner(System.in);

        for ( ; ; ) {
            System.out.println("Please, enter an expression in this format: a + b. Available operations are: +, -, *, /, pow.");
            exp = sc.nextLine();
            if (exp.equalsIgnoreCase(EXITCODE)) {
                break;
            }
            try {
                if (!checkExp(exp)) {
                    System.out.println("Invalid expression format.");
                    continue;
                }
                else {
                    double result = doCalculate(exp);
                    System.out.println("Result of expression: " + result);
                }
            }
            catch (PatternSyntaxException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
