package com.example.SehirRehberiAPI.Controller;

import com.cloudinary.Cloudinary;
import com.example.SehirRehberiAPI.Model.request.PhotoCreationRequestModel;
import com.example.SehirRehberiAPI.Model.response.PhotoRest;
import com.example.SehirRehberiAPI.Service.Impl.PhotoServiceImpl;
import com.example.SehirRehberiAPI.shared.Dto.PhotoDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://cityguiide.herokuapp.com")
@RestController
@RequestMapping
public class PhotoController {

    @Autowired
    private PhotoServiceImpl photoServiceImpl;

    @GetMapping("/cities/{city_id}/photos")
    public List<PhotoRest> getPhotosByCityId(@PathVariable long city_id){
        List<PhotoRest> returnValue = new ArrayList<>();

        List<PhotoDto> photosDTO = photoServiceImpl.getPhotosByCityId(city_id);

        if(photosDTO != null && !photosDTO.isEmpty()){
            java.lang.reflect.Type listType = new TypeToken<List<PhotoRest>>() {}.getType();
            returnValue = new ModelMapper().map(photosDTO,listType);
        }

        return returnValue;
    }

    @PostMapping(value = "/users/{user_id}/cities/{city_id}/photos/upload")
    public void uploadPhoto(@PathVariable long city_id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        ModelMapper mapper = new ModelMapper();

        PhotoCreationRequestModel requestModel = new PhotoCreationRequestModel();
        requestModel.setMultipartFile(multipartFile);
        requestModel.setCityId(city_id);

        photoServiceImpl.uploadPhoto(mapper.map(requestModel,PhotoDto.class));

    }


}
