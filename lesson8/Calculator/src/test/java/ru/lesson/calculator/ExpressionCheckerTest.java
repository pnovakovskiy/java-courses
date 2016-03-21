package ru.lesson.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionCheckerTest {
    private ExpressionChecker expressionChecker;

    @Before
    public void setUp() throws Exception {
        expressionChecker = new ExpressionChecker();
    }

    @Test
    public void testCheckExp() throws Exception {
        expressionChecker.setTemplate("\\-?\\d+(\\.\\d{0,})? (\\+|-|\\*|/|pow) \\-?\\d+(\\.\\d{0,})?");
        expressionChecker.setExpression("a + b");
        Assert.assertFalse(expressionChecker.checkExp());

        expressionChecker.setExpression("9.69 / -900");
        Assert.assertTrue(expressionChecker.checkExp());
    }
}