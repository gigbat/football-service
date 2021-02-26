package com.dev.football.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidatorImpl
        implements ConstraintValidator<EmailValidator, String> {
    private static final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(regex);
    }
}
