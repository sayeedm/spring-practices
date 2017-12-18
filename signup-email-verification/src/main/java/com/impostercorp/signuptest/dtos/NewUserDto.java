package com.impostercorp.signuptest.dtos;

import com.impostercorp.signuptest.validators.annotations.PasswordMatches;
import com.impostercorp.signuptest.validators.annotations.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Signup request body
 * Created by sayeedm on 7/4/17.
 */
@SuppressWarnings({ "unused", "SpellCheckingInspection" })
@PasswordMatches
public class NewUserDto {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    private String rePassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    private String contextPath;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
