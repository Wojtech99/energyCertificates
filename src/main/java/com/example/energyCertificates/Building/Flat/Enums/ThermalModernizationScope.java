package com.example.energyCertificates.Building.Flat.Enums;

import com.example.energyCertificates.Building.Enums.ExternalIsolationWallsType;

public enum ThermalModernizationScope {
    NULL("Brak"),
    ROOF_CHANGE("Wymiana dachu"),
    WALLS_INSULATION("Ocieplenie ścian"),
    WINDOWS_CHANGE("Wymiana Okien");

    private String nameInPolish;

    ThermalModernizationScope(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static ThermalModernizationScope mapToEnum(String nameInPolish) {
        for (ThermalModernizationScope enumType : ThermalModernizationScope.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }


}
