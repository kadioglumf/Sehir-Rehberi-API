package com.example.SehirRehberiAPI.Model.response;


import java.io.Serializable;

public class CityRest implements Serializable {

    private long id;
    private String name;
    private String description;
    private String photoUrl;

    public CityRest(long id, String name, String description, String photoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {

        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


}
