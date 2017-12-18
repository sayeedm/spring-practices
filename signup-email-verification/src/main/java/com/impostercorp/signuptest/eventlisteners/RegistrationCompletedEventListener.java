package com.impostercorp.signuptest.eventlisteners;

import com.impostercorp.signuptest.events.RegistrationCompletedEvent;
import com.impostercorp.signuptest.models.User;
import com.impostercorp.signuptest.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * When a registration is being completed a event is thrown
 * This Listener catches the event, generates a verification token and sends it via email
 *
 * Created by sayeedm on 12/18/17.
 */
@SuppressWarnings( { "unused", "SpellCheckingInspection" } )
@Component
public class RegistrationCompletedEventListener implements ApplicationListener<RegistrationCompletedEvent> {

    @Autowired
    private UsersService service;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(RegistrationCompletedEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getContextPath() + "/api/users/verify?token=" + token;


        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setFrom("support@impostercorp.com");
        email.setText("click link to verify \r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
