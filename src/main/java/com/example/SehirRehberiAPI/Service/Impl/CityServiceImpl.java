package com.example.SehirRehberiAPI.Service.Impl;

import com.example.SehirRehberiAPI.Entity.CityEntity;
import com.example.SehirRehberiAPI.Model.response.ErrorMessages;
import com.example.SehirRehberiAPI.Repository.CityRepository;
import com.example.SehirRehberiAPI.Service.CityService;
import com.example.SehirRehberiAPI.Model.response.CityRest;
import com.example.SehirRehberiAPI.exceptions.UserServiceException;
import com.example.SehirRehberiAPI.shared.Dto.CityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityRest> getAllCities() {
        return cityRepository.getAllCities();
    }

    @Override
    public List<CityRest> getAllCitiesByUser(long id){
        return cityRepository.CityDtoLeftJoin(id);
    }

    @Override
    public CityDto getCityById(long id) {
        CityEntity cityEntity = cityRepository.findById(id);
        if(cityEntity == null) throw new UserServiceException(ErrorMessages.ITEM_IS_NOT_FOUND.getErrorMessage());
        ModelMapper mapper = new ModelMapper();

        return mapper.map(cityEntity,CityDto.class);


    }

    @Override
    public CityDto getPhotosByCity(long id) {
        CityEntity cityEntity = cityRepository.findById(id);

        ModelMapper mapper = new ModelMapper();

        return mapper.map(cityEntity,CityDto.class);
    }

    @Override
    public void addCity(CityEntity cityEntity) {

        cityRepository.save(cityEntity);
    }

    public CityDto createCity(CityDto cityDto){
        ModelMapper mapper = new ModelMapper();

        CityEntity cityEntity = cityRepository.save(mapper.map(cityDto,CityEntity.class));
        return mapper.map(cityEntity,CityDto.class);
    }

}
