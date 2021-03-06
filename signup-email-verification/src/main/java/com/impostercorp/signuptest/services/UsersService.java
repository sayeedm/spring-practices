package com.impostercorp.signuptest.services;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.exceptions.EmailExistsException;
import com.impostercorp.signuptest.exceptions.NoVerificationTokenFoundException;
import com.impostercorp.signuptest.exceptions.VerificationTokenExpiredException;
import com.impostercorp.signuptest.models.User;

/**
 *
 * Created by sayeedm on 12/17/17.
 */
@SuppressWarnings( { "SpellCheckingInspection", "unused" })
public interface UsersService {
    User create(NewUserDto dto) throws EmailExistsException;
    void createVerificationTokenForUser(final User user, final String token);
    void verifyEmail(String token) throws VerificationTokenExpiredException, NoVerificationTokenFoundException;
}
