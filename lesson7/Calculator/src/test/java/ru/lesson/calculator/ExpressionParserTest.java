package ru.lesson.calculator;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionParserTest {

    @Test
    public void testParse() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1 * 125");
        expressionParser.parse();
        Assert.assertEquals(1, expressionParser.getOperand1(), 0);
        Assert.assertEquals(125, expressionParser.getOperand2(), 0);
        Assert.assertTrue(expressionParser.getOperation().equals("*"));
    }
}