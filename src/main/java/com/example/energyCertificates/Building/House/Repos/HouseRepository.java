package com.example.energyCertificates.Building.House.Repos;

import com.example.energyCertificates.Building.Flat.Flat;
import com.example.energyCertificates.Building.House.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
    void deleteById(Long id);

    @Query("select h from House h")
    List<House> getAll();

    House getByCityAndStreetAndHouseNumberAndPostalCodeAndSendFormDate(
            String city,
            String street,
            int houseNumber,
            String postalCode,
            Date sendFormDate
    );
}
