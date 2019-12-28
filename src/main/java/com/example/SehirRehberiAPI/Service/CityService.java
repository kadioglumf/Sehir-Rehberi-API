package com.example.SehirRehberiAPI.Service;

import com.example.SehirRehberiAPI.Entity.CityEntity;
import com.example.SehirRehberiAPI.Model.response.CityRest;
import com.example.SehirRehberiAPI.shared.Dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityRest> getAllCities();
    List<CityRest> getAllCitiesByUser(long id);
    CityDto getCityById(long id);
    CityDto getPhotosByCity(long id);
    void addCity(CityEntity cityEntity);
}
