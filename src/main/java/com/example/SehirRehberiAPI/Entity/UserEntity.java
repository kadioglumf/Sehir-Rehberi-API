package com.example.SehirRehberiAPI.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -3890806527742460444L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String encrypedPassword;

    private String emailVerificationToken;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean emailVerificationStatus;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<CityEntity> cityEntity;



    public List<CityEntity> getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(List<CityEntity> cityEntity) {
        this.cityEntity = cityEntity;
    }

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