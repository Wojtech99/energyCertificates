package com.example.energyCertificates.Building.Flat.Repos;

import com.example.energyCertificates.Building.Flat.ThermalModernizationScopeClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThermalModernizationScopeRepository extends CrudRepository<ThermalModernizationScopeClass, Long> {
    void deleteById(Long id);
}
