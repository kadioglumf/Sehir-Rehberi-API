package com.example.SehirRehberiAPI.Model.response;

import com.example.SehirRehberiAPI.Entity.PhotoEntity;

import java.util.List;

public class CityDetailRest {

    private long id;
    private String name;
    private String description;
    private List<PhotoEntity> photos;

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

    public List<PhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }
}
