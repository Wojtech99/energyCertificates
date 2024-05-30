package com.example.energyCertificates.Building.House.Repos;

import com.example.energyCertificates.Building.House.HouseWall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseWallRepository extends CrudRepository<HouseWall, Long> {

    void deleteById(Long id);
}
