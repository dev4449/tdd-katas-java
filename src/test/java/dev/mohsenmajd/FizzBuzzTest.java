package dev.mohsenmajd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void shouldInitializeWithSuccess() {
        new FizzBuzz();
    }

    @Test
    public void shouldReturnTheStringRepresentationWhenGivenANumber() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("1", fizzBuzz.toStringRepresentation(1));

    }

    @Test
    public void shouldReturnFizzWhenGivenMultipliesOfThree() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("Fizz", fizzBuzz.toStringRepresentation(3));
    }

    @Test
    public void shouldReturnBuzzWhenGivenMultipliesOfFive() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("Buzz", fizzBuzz.toStringRepresentation(5));
    }

    @Test
    public void shouldReturnFizzBuzzWhenGivenMultipliesOfThreeAndFive() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("FizzBuzz", fizzBuzz.toStringRepresentation(15));
    }

}
