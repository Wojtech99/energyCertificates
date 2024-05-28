package com.example.energyCertificates.Building.Flat.Repos;

import com.example.energyCertificates.Building.Flat.ThermalModernizationScopeClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThermalModernizationScopeRepository extends CrudRepository<ThermalModernizationScopeClass, Long> {
}
