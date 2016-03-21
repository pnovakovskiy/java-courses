package ru.lesson.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Класс, реализующий проверку выражения на соответствие шаблону
 */
public class ExpressionChecker {
    /**
     * Константа, описывающая шаблон вводимого пользователем выражения
     */
    private String template;

    public void setTemplate(final String template) {
        this.template = template;
    }

    /**
     * Константа, описывающая введенное пользователем выражение
     */
    private String expression;

    public void setExpression(final String expression) {
        this.expression = expression;
    }

    /**
     * Проверяет введенное пользователем выражение (expression) на соответствие шаблону (template)
     * @return true or false
     * @throws PatternSyntaxException
     */
    public boolean checkExp() throws PatternSyntaxException {
        Pattern p = Pattern.compile(template);
        Matcher m = p.matcher(expression);
        return m.matches();
    }
}
