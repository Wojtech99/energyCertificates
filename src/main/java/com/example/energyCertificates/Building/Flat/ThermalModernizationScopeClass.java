package com.example.energyCertificates.Building.Flat;

import com.example.energyCertificates.Building.Flat.Enums.ThermalModernizationScope;
import jakarta.persistence.*;

@Entity
public class ThermalModernizationScopeClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ThermalModernizationScope enumNumber;

    public ThermalModernizationScopeClass() {}

    public ThermalModernizationScopeClass(ThermalModernizationScope enumNumber) {
        this.enumNumber = enumNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ThermalModernizationScope getEnumNumber() {
        return enumNumber;
    }

    public void setEnumNumber(ThermalModernizationScope enumNumber) {
        this.enumNumber = enumNumber;
    }
}
