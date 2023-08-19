package dev.mohsenmajd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    @Test
    public void shouldInitializeWithSuccess() {
        new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenGivenAnEmptyString() {
        var stringCalculator = new StringCalculator();

        assertEquals(0, stringCalculator.calculate(""));
    }

    @Test
    public void shouldReturnIntegerEquivalentWhenGivenAStringNumber() {
        var stringCalculator = new StringCalculator();

        assertEquals(1, stringCalculator.calculate("1"));
    }

    @Test
    public void shouldReturnTheSumWhenGivenTwoNumbersAsString() {
        var stringCalculator = new StringCalculator();

        assertEquals(3, stringCalculator.calculate("1,2"));
    }

    @Test
    public void shouldAcceptUnknownNumberOfArguments() {
        var stringCalculator = new StringCalculator();
        stringCalculator.calculate("1","2");
    }

    @Test
    public void shouldHandleNewLinesAsSeparator() {
        var stringCalculator = new StringCalculator();

        assertEquals(6, stringCalculator.calculate("1,2\n3"));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenThereIsADelimiterAtTheEnd() {
        var stringCalculator = new StringCalculator();

        assertThrows(IllegalArgumentException.class, () -> stringCalculator.calculate("1,2,"));
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.calculate("1,2\n"));
    }

    @Test
    public void shouldHandleDifferentDelimiters() {
        var stringCalculator = new StringCalculator();

        assertEquals(4, stringCalculator.calculate("//;\n1;3"));
        assertEquals(6, stringCalculator.calculate("//|\n1|2|3"));
        assertEquals(7, stringCalculator.calculate("//sep\n2sep5"));
    }
}
