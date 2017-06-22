package com.impostercorp.rawwstest.models;

/**
 * when a user enters or leaves
 * Created by sayeedm on 3/10/17.
 */
public class UserStatusMessage {

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status{
        ENTRY, LEAVE
    }
    private String user;
    private Status status;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
