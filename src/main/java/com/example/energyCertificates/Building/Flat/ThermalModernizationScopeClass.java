package com.example.energyCertificates.Building.Flat;

import jakarta.persistence.*;

@Entity
public class ThermalModernizationScopeClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int enumNumber;

    public ThermalModernizationScopeClass() {}

    public ThermalModernizationScopeClass(int enumNumber) {
        this.enumNumber = enumNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEnumNumber() {
        return enumNumber;
    }

    public void setEnumNumber(int enumNumber) {
        this.enumNumber = enumNumber;
    }
}
