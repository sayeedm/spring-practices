package com.impostercorp.signuptest.models;

import com.impostercorp.signuptest.dtos.NewUserDto;

import javax.persistence.*;

/**
 *
 * Created by sayeedm on 12/17/17.
 */
@Entity
@Table(name = "users")
public class User {
    private String firstName;
    private String lastName;
    private String password;

    @Id
    private String email;
    private boolean enabled;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public static User fromNewUserDto(NewUserDto dto){
        User user = new User();
        user.email = dto.getEmail();
        user.enabled = false;
        user.firstName = dto.getFirstName();
        user.lastName = dto.getLastName();
        user.password = dto.getPassword();
        return user;
    }
}
