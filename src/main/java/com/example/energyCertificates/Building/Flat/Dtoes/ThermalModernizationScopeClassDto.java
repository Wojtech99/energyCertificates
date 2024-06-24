package com.example.energyCertificates.Building.Flat.Dtoes;

import com.example.energyCertificates.Building.Flat.Enums.ThermalModernizationScope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.energyCertificates.Building.Flat.ThermalModernizationScopeClass}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThermalModernizationScopeClassDto implements Serializable {
    private Long id;
    private ThermalModernizationScope enumNumber;

    public ThermalModernizationScopeClassDto(ThermalModernizationScope thermalModernizationScope) {
        this.enumNumber = thermalModernizationScope;
    }
}