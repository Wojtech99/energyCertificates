package com.example.energyCertificates.Flat.Enums;

public enum RadiatorsType {
    PLATE("Płytowe"),
    PARTIAL("Członowe (żeberkowe)"),
    CAST_IRON("Żeliwne"),
    FLOOR_HEATING("Ogrzewanie podłogowe"),
    HEATING_FROM_FIREPLACE("Ogrzewanie z kominka lub pieca");

    private String nameInPolish;

    RadiatorsType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
