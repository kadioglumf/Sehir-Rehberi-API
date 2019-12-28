package com.example.SehirRehberiAPI.Model.request;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class PhotoCreationRequestModel {

    private long cityId;
    private MultipartFile multipartFile;
    private LocalDateTime dateAdded;

    public PhotoCreationRequestModel() {

        this.dateAdded = LocalDateTime.now();
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

}
