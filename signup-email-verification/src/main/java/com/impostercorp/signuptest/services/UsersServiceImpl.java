package com.impostercorp.signuptest.services;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.exceptions.EmailExistsException;
import com.impostercorp.signuptest.models.User;
import com.impostercorp.signuptest.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by sayeedm on 12/17/17.
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository repository;

    @Override
    public User create(NewUserDto dto) throws EmailExistsException {
        if (repository.findOne(dto.getEmail()) != null)
            throw new EmailExistsException();

        return repository.save(User.fromNewUserDto(dto));
    }
}
