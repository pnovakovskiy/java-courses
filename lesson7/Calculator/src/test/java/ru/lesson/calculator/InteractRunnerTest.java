package ru.lesson.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class InteractRunnerTest {
    @Test
    public void testDoCalculate() {
        Scanner scanner = new Scanner("-100.2 / 25");
        Calculator calculator = new Calculator();
        InteractRunner interactRunner = new InteractRunner(scanner, calculator);
        interactRunner.doCalculate(scanner.nextLine());
        Assert.assertEquals(calculator.getResult(), -4.008, 0);
    }
}
