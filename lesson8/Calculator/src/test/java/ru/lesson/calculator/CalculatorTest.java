package ru.lesson.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        calculator.cleanResult();
        calculator.add(1.12, 4);
        Assert.assertEquals(5.12, calculator.getResult(), 0);

        calculator.cleanResult();
        calculator.add(-16.35, -0.65, 5, 3);
        Assert.assertEquals(-9, calculator.getResult(), 0);
    }

    @Test
    public void testSubtrac() throws Exception {
        calculator.cleanResult();
        calculator.subtrac(567, 13);
        Assert.assertEquals(554, calculator.getResult(), 0);

        calculator.cleanResult();
        calculator.subtrac(-5.5, -5.5);
        Assert.assertEquals(0, calculator.getResult(), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        calculator.cleanResult();
        calculator.multiply(1.5, 2, -3);
        Assert.assertEquals(-9, calculator.getResult(), 0);
    }

    @Test
    public void testDivide() throws Exception {
        calculator.cleanResult();
        calculator.divide(100, 25.0);
        Assert.assertEquals(4, calculator.getResult(), 0);
    }

    @Test
    public void testPow() throws Exception {
        calculator.cleanResult();
        calculator.pow(2, 8);
        Assert.assertEquals(256, calculator.getResult(), 0);
    }

    @Test
    public void testGetResult() throws Exception {
        calculator.cleanResult();
        calculator.add(2, -8);
        Assert.assertEquals(-6, calculator.getResult(), 0);
    }

    @Test
    public void testCleanResult() throws Exception {
        calculator.cleanResult();
        calculator.divide(6, -1);
        calculator.cleanResult();
        Assert.assertEquals(0, calculator.getResult(), 0);
    }
}