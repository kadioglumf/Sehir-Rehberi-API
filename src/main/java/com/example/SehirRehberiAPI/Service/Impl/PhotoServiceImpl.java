package com.example.SehirRehberiAPI.Service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.SehirRehberiAPI.Entity.PhotoEntity;
import com.example.SehirRehberiAPI.Repository.CityRepository;
import com.example.SehirRehberiAPI.Repository.PhotoRepository;
import com.example.SehirRehberiAPI.Service.PhotoService;
import com.example.SehirRehberiAPI.shared.Dto.PhotoDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    Cloudinary cloudinary;

    @Override
    public List<PhotoDto> getPhotosByCityId(long city_id) {
        List<PhotoDto> returnValue = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        Iterable<PhotoEntity> photos = photoRepository.findByCityId(city_id);

        java.lang.reflect.Type listType = new TypeToken<List<PhotoDto>>() {}.getType();
        returnValue = mapper.map(photos,listType);

        return returnValue;
    }

    public void uploadPhoto(PhotoDto photoDto) throws IOException {

        ModelMapper mapper = new ModelMapper();

        List<PhotoEntity> storedPhoto = photoRepository.findByCityId(photoDto.getCityId());
        if(!storedPhoto.stream().anyMatch(p-> p.isMain())){
            photoDto.setMain(true);
        }
        else{
            photoDto.setMain(false);
        }

        File convertFile = convertMultiPartToFile(photoDto.getMultipartFile());
        if(convertFile.length() != 0) {

            Map uploadResult = cloudinary.uploader().upload(convertFile, ObjectUtils.emptyMap());

            photoDto.setUrl(uploadResult.get("url").toString());
            photoDto.setPublicId(uploadResult.get("public_id").toString());

        }
        PhotoEntity photoEntity = mapper.map(photoDto,PhotoEntity.class);
        photoRepository.save(photoEntity);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
