package org.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    public void testMoreThanTwoNumbers() {
        StringCalculator calculator = new StringCalculator();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,2,3");
        });

        assertEquals("Input contains more than 2 numbers", exception.getMessage());
    }
    @Test
    public void testSingleString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
}