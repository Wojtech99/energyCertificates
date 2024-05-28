package com.example.energyCertificates.Building.Flat.Repos;

import com.example.energyCertificates.Building.Flat.Flat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends CrudRepository<Flat, Long> {
}
