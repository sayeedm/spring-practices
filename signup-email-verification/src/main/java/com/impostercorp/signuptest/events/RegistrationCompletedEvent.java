package com.impostercorp.signuptest.events;

import com.impostercorp.signuptest.models.User;
import org.springframework.context.ApplicationEvent;

/**
 *
 * Created by sayeedm on 12/18/17.
 */
@SuppressWarnings( { "unused", "SpellCheckingInspection" } )
public class RegistrationCompletedEvent extends ApplicationEvent {

    private User user;
    private String contextPath;

    public RegistrationCompletedEvent(User user, String contextPath) {
        super(user);
        this.user = user;
        this.contextPath = contextPath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
