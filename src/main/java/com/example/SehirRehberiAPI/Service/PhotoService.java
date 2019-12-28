package com.example.SehirRehberiAPI.Service;


import com.example.SehirRehberiAPI.shared.Dto.PhotoDto;

import java.util.List;

public interface PhotoService {
    List<PhotoDto> getPhotosByCityId(long city_id);
}
