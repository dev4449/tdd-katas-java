package dev.mohsenmajd.passwordvalidator;

public class ValidationResult {
    private boolean valid;
    private String validationErrors;

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setValidationErrors(String validationErrors) {
        this.validationErrors = validationErrors;
    }

    public boolean isValid() {
        return valid;
    }

    public String getValidationErrors() {
        return validationErrors;
    }
}
