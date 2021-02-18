package com.dev.cinema;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidatorImpl
        implements ConstraintValidator<EmailValidator, String> {
    private static final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext validator) {
        return field != null && field.matches(regex);
    }
}
