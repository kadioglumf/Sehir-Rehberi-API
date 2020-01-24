
package com.example.SehirRehberiAPI.Controller;


import com.example.SehirRehberiAPI.Model.request.CityCreationRequestModel;
import com.example.SehirRehberiAPI.Model.response.CityRest;
import com.example.SehirRehberiAPI.Model.response.CityDetailRest;
import com.example.SehirRehberiAPI.Service.Impl.CityServiceImpl;
import com.example.SehirRehberiAPI.shared.Dto.CityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "https://cityguiide.herokuapp.com")
@RestController
@RequestMapping
public class CityController {

    @Autowired
    private CityServiceImpl cityServiceImpl;

    @GetMapping("/cities")
    public List<CityRest> getAllCities(){
        return cityServiceImpl.getAllCities();
    }

    @GetMapping("/users/{user_id}/cities")
    public List<CityRest> getAllCitiesByUser(@PathVariable("user_id") long user_id){
        return cityServiceImpl.getAllCitiesByUser(user_id);
    }

    @GetMapping("/cities/detail/{id}")
    public CityDetailRest getCityById(@PathVariable long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(cityServiceImpl.getCityById(id), CityDetailRest.class);
    }

    @PostMapping("/users/{user_id}/cities/add")
    @ResponseBody
    public CityDetailRest createCity(@RequestBody CityCreationRequestModel cityCreationRequestModel) {
        ModelMapper mapper = new ModelMapper();

        CityDto cityDto = cityServiceImpl.createCity(mapper.map(cityCreationRequestModel,CityDto.class));
        return mapper.map(cityDto,CityDetailRest.class);
    }

}
