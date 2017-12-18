package com.impostercorp.signuptest.services;

import com.impostercorp.signuptest.dtos.NewUserDto;
import com.impostercorp.signuptest.events.RegistrationCompletedEvent;
import com.impostercorp.signuptest.exceptions.EmailExistsException;
import com.impostercorp.signuptest.exceptions.NoVerificationTokenFoundException;
import com.impostercorp.signuptest.exceptions.VerificationTokenExpiredException;
import com.impostercorp.signuptest.models.User;
import com.impostercorp.signuptest.models.VerificationToken;
import com.impostercorp.signuptest.repositories.UsersRepository;
import com.impostercorp.signuptest.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 *
 * Created by sayeedm on 12/17/17.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private VerificationTokenRepository tokenRepository;


    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public User create(NewUserDto dto) throws EmailExistsException {
        if (repository.findOne(dto.getEmail()) != null)
            throw new EmailExistsException();

        User createdUser = repository.save(User.fromNewUserDto(dto));
        if (createdUser != null){
            eventPublisher.publishEvent(new RegistrationCompletedEvent(createdUser, dto.getContextPath()));
        }
        return createdUser;
    }

    @Override
    public void createVerificationTokenForUser(final User user, final String token) {
        final VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setToken(token);

        tokenRepository.save(verificationToken);
    }

    @Override
    public void verifyEmail(String token) throws NoVerificationTokenFoundException, VerificationTokenExpiredException {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null)
            throw new NoVerificationTokenFoundException();

        User user = verificationToken.getUser();

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0)
            throw new VerificationTokenExpiredException();


        user.setEnabled(true);
        repository.save(user);
    }
}
