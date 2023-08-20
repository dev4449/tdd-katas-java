package dev.mohsenmajd;

import dev.mohsenmajd.passwordvalidator.PasswordValidator;
import dev.mohsenmajd.passwordvalidator.ValidationResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {
    @Test
    public void shouldInstantiateSuccessfully() {
        var passwordValidator = new PasswordValidator();
    }

    @Test
    public void shouldReturnAppropriateValidationResultWhenThePasswordIsLessThan8Characters() {
        var passwordValidator = new PasswordValidator();
        ValidationResult validationResult = passwordValidator.validate("hello");
        assertFalse(validationResult.isValid());
        assertTrue(validationResult.getValidationErrors().contains("Password must be at least 8 characters"));
    }


    @Test
    public void shouldReturnAppropriateValidationResultWhenThePasswordDoesNotContainAtLeast2Numbers() {
        var passwordValidator = new PasswordValidator();
        ValidationResult validationResult = passwordValidator.validate("hello");
        assertFalse(validationResult.isValid());
        assertTrue(validationResult.getValidationErrors().contains("The password must contain at least 2 numbers"));
    }
    @Test
    public void shouldHandleMultipleValidationErrors(){
        var passwordValidator = new PasswordValidator();

        ValidationResult validationResult = passwordValidator.validate("hello");

        assertFalse(validationResult.isValid());
        assertTrue( validationResult.getValidationErrors().contains("Password must be at least 8 characters"));
        assertTrue( validationResult.getValidationErrors().contains("The password must contain at least 2 numbers"));

    }

    @Test
    public void shouldReturnAppropriateValidationResultWhenNoCapitalLetterIsGiven(){
        var passwordValidator = new PasswordValidator();

        ValidationResult validationResult = passwordValidator.validate("hello");
        assertFalse(validationResult.isValid());
        assertTrue( validationResult.getValidationErrors().contains("password must contain at least one capital letter"));
    }

    @Test
    public void shouldReturnAppropriateValidationResultWhenNoSpecialCharacterIsGiven(){
        var passwordValidator = new PasswordValidator();

        ValidationResult validationResult = passwordValidator.validate("hello");

        assertFalse(validationResult.isValid());
        assertTrue( validationResult.getValidationErrors().contains("password must contain at least one special character"));
    }
}
