package com.dev.cinema.model.dto;

import com.dev.cinema.validator.EmailValidator;
import com.dev.cinema.validator.PasswordValidator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordValidator
public class UserRequestDto {
    @NotNull
    @EmailValidator
    private String email;
    @NotNull
    @Size(min = 8)
    private String password;
    @NotNull
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
