/**
 * Класс, реализующий калькулятор.
 */
public class Calculator {
    /**
     * Результат вычисления
     */
    private double result;
    /**
     * Суммировать аргументы
     */
    public void add(double ... params) {
        for (double param : params) {
            this.result += param;
        }
    }

    /**
     * Вычесть из первого аргумента второй
     */
    public void subtrac(double a, double b) {
        this.result = a - b;
    }

    /**
     * Перемножить аргументы
     */
    public void multiply(double ... params) {
        this.result = 1;
        for (double param : params) {
            this.result *= param;
        }
    }

    /**
     * Разделить первый аргумент на второй
     */
    public void divide(double a, double b) {
        try {
            this.result = a / b;
        }
        catch (ArithmeticException exc) {
            System.out.println(exc.getMessage());
        }
    }

    /**
     * Возвести в степень
     */
    public void pow (double a, double b) {
        this.result = Math.pow(a, b);
    }

    /**
     * Получить результат
     * @return результат вычисления
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Очистить результат вычисления
     */
    public void cleanResult() {
        this.result = 0;
    }
}
