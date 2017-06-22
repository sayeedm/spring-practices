package com.impostercorp.rawwstest.models;

/**
 * Represents a chat message
 *
 * Created by sayeedm on 3/10/17.
 */
public class ChatMessage {

    private String user;
    private String message;
    private Long timestamp;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
