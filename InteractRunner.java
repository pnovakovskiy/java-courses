import java.util.Scanner;
import java.util.regex.*;

public class InteractRunner {
    /**
     * Константа, описывающая шаблон вводимого пользователем выражения
     */
    private final String REGEXP = "\\-?\\d+(\\.\\d{0,})? (\\+|-|\\*|/|pow) \\-?\\d+(\\.\\d{0,})?";

    /**
     * Константа. Содержит текст, который необходимо ввести пользователю для выхода из программы
     */
    private final String EXITCODE = "Exit";

    /**
     * Константа. Содержит текст, который необходимо ввести пользователю для использования результата
     * предыдущей операции
     */
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
        try {
            // получаем первый операнд из переданного выражения
            double operandFirst = Double.parseDouble(exp.substring(0, exp.indexOf(" ")));
            // получаем операцию из переданного выражения
            String operation = exp.substring(exp.indexOf(" ") + 1, exp.lastIndexOf(" "));
            // получаем второй операнд из переданного выражения
            double operandSecond = Double.parseDouble(exp.substring(exp.lastIndexOf(" ") + 1, exp.length()));

            // в зависимости от переданной операции выполняем соотвествующее вычисление
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
        }
        catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException  exc) {
            System.out.println(exc.getMessage());
        }
    }
    public static void main(String[] args) {
        // вычисляемое выражение
        String exp = "";
        // вводимое пользователем выражение
        String expTmp = "";
        // результат выражения
        double result = 0;
        // использовать результат предыдущего вычисления или нет
        boolean usePrevOperResult = false;

        System.out.println("Calculate...");
        System.out.println("Type 'Exit' to stop the programm.");

        // создаем экземпляр класса Calculator
        Calculator calc = new Calculator();

        try (Scanner sc = new Scanner(System.in)) {
            InteractRunner ir = new InteractRunner();

            // бесконечный цикл вычсиления выражения до тех пор,
            // пока пользователл не введет Exit
            for ( ; ; ) {
                if (usePrevOperResult) {
                    System.out.println("Please, enter an expression without leading space in this format: + b to use previous operation result. Available operations are: +, -, *, /, pow:");
                }
                else {
                    System.out.println("Please, enter an expression in this format: a + b. Available operations are: +, -, *, /, pow:");
                }
                expTmp = sc.nextLine();

                /**
                 * получаем вычисляемое выражение в зависимости от того,
                 * используем ли мы предыдущий результат или нет
                 */
                exp = (usePrevOperResult) ? (result + " " + expTmp) : expTmp;
                // прерываем цикл, если пользователь ввел значение константы EXITCODE
                if (expTmp.equalsIgnoreCase(ir.EXITCODE)) {
                    break;
                }

                // если введенное выражение не соответствует формату - ругаемся
                if (!ir.checkExp(exp)) {
                    System.out.println("Invalid expression format.");
                    continue;
                }
                // если соответствует - вычисляем
                else {
                    ir.doCalculate(exp, calc);
                    result = calc.getResult();
                    calc.cleanResult();
                    System.out.println("Result of expression: " + result);

                    System.out.println("Do you want to use current result in next expression? (yes/no):");
                    expTmp = sc.nextLine();

                    // в зависимости от ответа пользователя используем или нет результат предыдущего вычисления
                    usePrevOperResult = (expTmp.equalsIgnoreCase(ir.USECURRRESULTCODE)) ? true : false;
                }
            }
        }
        catch (PatternSyntaxException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
