package ru.lesson.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class InteractRunnerTest {
    @Test
    public void testRunExec() {
        String s = "-100.2 / 25\nno\nexit";
        Scanner scanner = new Scanner(s);
        Calculator calculator = new Calculator();
        InteractRunner interactRunner = new InteractRunner(scanner, calculator);
        interactRunner.runExec();
        Assert.assertEquals(calculator.getResult(), -4.008, 0);
    }

    @Test
    public void testDoCalculate() {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        InteractRunner interactRunner = new InteractRunner(scanner, calculator);
        calculator.cleanResult();
        interactRunner.doCalculate("-1 + 25");
        Assert.assertEquals(calculator.getResult(), 24, 0);
    }
}
