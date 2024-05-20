package com.example.energyCertificates.Flat.Enums;

public enum ThermalModernizationScope {
    ROOF_CHANGE("Wymiana dachu"),
    WALLS_INSULATION("Ociepplenie ścian"),
    WINDOWS_CHANGE("Wymiana Okien");

    private String nameInPolish;

    ThermalModernizationScope(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }


}
