package com.dev.cinema.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidatorImpl.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    String fieldMatch() default "repeatPassword";

    String message() default "Password wasn't matched";

    String field() default "password";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
