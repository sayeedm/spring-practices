package com.impostercorp.signuptest.services;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.exceptions.EmailExistsException;
import com.impostercorp.signuptest.models.User;

/**
 *
 * Created by sayeedm on 12/17/17.
 */
public interface UsersService {
    User create(NewUserDto dto) throws EmailExistsException;
}
