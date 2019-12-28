package com.example.SehirRehberiAPI.Repository;

import com.example.SehirRehberiAPI.Model.response.CityRest;
import com.example.SehirRehberiAPI.Entity.CityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {

    @Query(value = "SELECT new com.example.SehirRehberiAPI.Model.response.CityRest(c.id, c.name, c.description, p.url) "
            + "FROM CityEntity c LEFT JOIN c.photos p where (p.isMain=true and c.user_id =:user_id)")
    List<CityRest> CityDtoLeftJoin(@Param("user_id") long user_id);

    @Query(value = "SELECT new com.example.SehirRehberiAPI.Model.response.CityRest(c.id, c.name, c.description, p.url) "
            + "FROM CityEntity c LEFT JOIN c.photos p where p.isMain=true")
    List<CityRest> getAllCities();

    CityEntity findById(long id);
}
