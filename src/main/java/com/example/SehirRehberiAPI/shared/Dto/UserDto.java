package com.example.SehirRehberiAPI.shared.Dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = -5866774041189580572L;
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encrypedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncrypedPassword() {
        return encrypedPassword;
    }

    public void setEncrypedPassword(String encrypedPassword) {
        this.encrypedPassword = encrypedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

}
