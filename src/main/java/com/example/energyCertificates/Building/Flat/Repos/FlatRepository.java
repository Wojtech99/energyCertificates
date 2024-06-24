package com.example.energyCertificates.Building.Flat.Repos;

import com.example.energyCertificates.Building.Flat.Flat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FlatRepository extends CrudRepository<Flat, Long> {
    void deleteById(Long id);

    @Query("select f from Flat f")
    List<Flat> getAll();

    Flat getByCityAndStreetAndPostalCodeAndSendFormDate(
            String city,
            String street,
            String postalCode,
            Date sendFormDate
    );
}
