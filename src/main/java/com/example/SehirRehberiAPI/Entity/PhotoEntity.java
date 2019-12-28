package com.example.SehirRehberiAPI.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "photos")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,name = "city_id")
    private long cityId;

    private LocalDateTime dateAdded;

    @Column(nullable = false)
    private String url;

    private String publicId;

    @Column(nullable = false,columnDefinition = "boolean default false")
    private Boolean isMain;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public Boolean getMain() {
        return isMain;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public Boolean isMain() {
        return isMain;
    }

    public void setMain(Boolean main) {
        isMain = main;
    }
}

