package com.impostercorp.signuptest.validators;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.validators.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * Created by sayeedm on 7/10/17.
 */
@SuppressWarnings( { "SpellCheckingInspection", "unused" })
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        NewUserDto dto = (NewUserDto)o;
        return dto.getPassword().equals(dto.getRePassword());
    }
}
