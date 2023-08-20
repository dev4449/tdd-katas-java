package dev.mohsenmajd.passwordvalidator;

public class PasswordValidator {
    public ValidationResult validate(String password){
        var validationResult = new ValidationResult();

        validationResult.setValid(true);
        validationResult.setValidationErrors("NONE");

        if( password.length() < 8 ){
            validationResult.setValid(false);
            validationResult.setValidationErrors("Password must be at least 8 characters\n");
        }
        if( !password.matches("(\\D*\\d){2,}") ){
            validationResult.setValid(false);
            validationResult.setValidationErrors(
                    validationResult.getValidationErrors() +
                    "The password must contain at least 2 numbers\n"
            );
        }
        if( !password.matches(".*[A-Z].*") ){
            validationResult.setValid(false);
            validationResult.setValidationErrors(
                    validationResult.getValidationErrors() +
                            "password must contain at least one capital letter"
            );
        }
        if( password.matches("[a-zA-Z0-9 ]*")){
            validationResult.setValid(false);
            validationResult.setValidationErrors(
                    validationResult.getValidationErrors() +
                            "password must contain at least one special character"
            );
        }
        return validationResult;

    }
}
