package com.impostercorp.practices.spring.elastic.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;

@SuppressWarnings("unused")
@Document(indexName = "greetings_index", type = "greetings")
public class Greeting implements Serializable {

    @Id
    private String id;
    private String username;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
