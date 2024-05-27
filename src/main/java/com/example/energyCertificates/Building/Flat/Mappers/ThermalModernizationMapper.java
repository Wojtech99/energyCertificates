package com.example.energyCertificates.Building.Flat.Mappers;

import com.example.energyCertificates.Building.Flat.Dtoes.ThermalModernizationScopeClassDto;
import com.example.energyCertificates.Building.Flat.ThermalModernizationScopeClass;
import org.springframework.stereotype.Component;

@Component
public class ThermalModernizationMapper {
    public static ThermalModernizationScopeClass map(ThermalModernizationScopeClassDto thermalModernizationScopeClassDto) {
        ThermalModernizationScopeClass thermalModernizationScopeClass = new ThermalModernizationScopeClass(
                thermalModernizationScopeClassDto.getEnumNumber()
        );

        thermalModernizationScopeClass.setId(thermalModernizationScopeClassDto.getId());

        return thermalModernizationScopeClass;
    }

    public static ThermalModernizationScopeClassDto map(ThermalModernizationScopeClass thermalModernizationScopeClass) {
        return new ThermalModernizationScopeClassDto(
                thermalModernizationScopeClass.getId(),
                thermalModernizationScopeClass.getEnumNumber()
        );
    }
}
