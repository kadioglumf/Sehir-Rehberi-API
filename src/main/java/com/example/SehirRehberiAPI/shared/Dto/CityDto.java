package com.example.SehirRehberiAPI.shared.Dto;

import java.io.Serializable;
import java.util.List;

public class CityDto implements Serializable {
    private static final long serialVersionUID = -5866774041189580572L;

    private long id;
    private String name;
    private String description;
    private long user_id;
    private List<PhotoDto> photos;

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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDto> photos) {
        this.photos = photos;
    }
}
