package com.example.energyCertificates.Building.House.Repos;

import com.example.energyCertificates.Building.House.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
}
