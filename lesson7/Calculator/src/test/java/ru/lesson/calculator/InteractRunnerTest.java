package ru.lesson.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class InteractRunnerTest {
    @Test
    public void testDoCalculate() {
        String s = "-100.2 / 25\nno\nexit";
        Scanner scanner = new Scanner(s);
        Calculator calculator = new Calculator();
        InteractRunner interactRunner = new InteractRunner(scanner, calculator);
        //interactRunner.doCalculate(scanner.nextLine());
        Assert.assertEquals(calculator.getResult(), -4.008, 0);
    }
}
