package com.example.energyCertificates.Building.Flat.service;

import com.example.energyCertificates.Building.Flat.Dtoes.ThermalModernizationScopeClassDto;
import com.example.energyCertificates.Building.Flat.Mappers.ThermalModernizationMapper;
import com.example.energyCertificates.Building.Flat.Repos.ThermalModernizationScopeRepository;
import com.example.energyCertificates.Building.Flat.ThermalModernizationScopeClass;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ThermalModernizationScopeService {
    private final ThermalModernizationScopeRepository thermalRepository;

    public ThermalModernizationScopeService(ThermalModernizationScopeRepository thermalModernizationScopeRepository) {
        this.thermalRepository = thermalModernizationScopeRepository;
    }

    @Transactional
    ThermalModernizationScopeClassDto save(ThermalModernizationScopeClassDto thermalDto) {
        ThermalModernizationScopeClass thermalToSave = ThermalModernizationMapper
                .map(thermalDto);
        ThermalModernizationScopeClass savedThermal = thermalRepository.save(thermalToSave);

        return ThermalModernizationMapper.map(savedThermal);
    }

    @Transactional
    void delete(ThermalModernizationScopeClassDto thermalDto) {
        ThermalModernizationScopeClass thermalToDelete = ThermalModernizationMapper
                .map(thermalDto);
        thermalRepository.deleteById(thermalToDelete.getId());
    }
}
