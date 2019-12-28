package com.example.SehirRehberiAPI.Repository;

import com.example.SehirRehberiAPI.Entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
    List<PhotoEntity> findByCityId(long city_id);


}
