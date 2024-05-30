package com.example.energyCertificates.Building.Flat.service;

import com.example.energyCertificates.Building.FilteringCondition;
import com.example.energyCertificates.Building.Flat.Dtoes.FlatDto;
import com.example.energyCertificates.Building.Flat.Dtoes.ThermalModernizationScopeClassDto;
import com.example.energyCertificates.Building.Flat.Flat;
import com.example.energyCertificates.Building.Flat.Mappers.FlatMapper;
import com.example.energyCertificates.Building.Flat.Repos.FlatRepository;
import com.example.energyCertificates.Data.DataDto;
import com.example.energyCertificates.Data.DataService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlatService {
    private final FlatRepository flatRepository;
    private final ThermalModernizationScopeService thermalService;
    private final DataService dataService;

    public FlatService(FlatRepository flatRepository, ThermalModernizationScopeService thermalService, DataService dataService) {
        this.flatRepository = flatRepository;
        this.thermalService = thermalService;
        this.dataService = dataService;
    }

    @Transactional
    FlatDto save(FlatDto flatDto) {
        List<ThermalModernizationScopeClassDto> thermalDtoList= flatDto.getThermalModernizationScopeList();
        List<DataDto> dataDtoList = flatDto.getAttachments();

        thermalDtoList.forEach(thermalService::save);
        dataDtoList.forEach(dataService::save);

        Flat flatToSave = FlatMapper.map(flatDto);
        Flat savedFlat = flatRepository.save(flatToSave);

        return FlatMapper.map(savedFlat);
    }

    @Transactional
    void delete(FlatDto flatDto) {
        List<ThermalModernizationScopeClassDto> thermalDtoList= flatDto.getThermalModernizationScopeList();
        List<DataDto> dataDtoList = flatDto.getAttachments();

        thermalDtoList.forEach(thermalService::delete);
        dataDtoList.forEach(dataService::delete);

        Flat flatToDelete = FlatMapper.map(flatDto);
        flatRepository.deleteById(flatToDelete.getId());
    }

    List<FlatDto> getFlatWithCondition(FilteringCondition filteringCondition) {
        List<FlatDto> flatDtoList = flatRepository.getAll().stream()
                .map(FlatMapper::map)
                .toList();
        List<FlatDto> filteredFlatDtoList = new ArrayList<>();

        for (FlatDto flatDto : flatDtoList) {
            if (filteringCondition.filter(flatDto)) {
                filteredFlatDtoList.add(flatDto);
            }
        }

        return filteredFlatDtoList;
    }
}
