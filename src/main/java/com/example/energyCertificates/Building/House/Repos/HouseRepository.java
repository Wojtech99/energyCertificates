package com.example.energyCertificates.Building.House.Repos;

import com.example.energyCertificates.Building.House.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
    void deleteById(Long id);

    @Query("select h from House h")
    List<House> getAll();
}
