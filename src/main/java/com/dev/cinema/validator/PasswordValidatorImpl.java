package com.dev.cinema.validator;

import com.dev.cinema.model.dto.UserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidatorImpl
        implements ConstraintValidator<PasswordValidator, UserRequestDto> {
    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userRequestDto != null && userRequestDto.getPassword() != null
                && userRequestDto.getPassword().equals(userRequestDto
                .getRepeatPassword());
    }
}
