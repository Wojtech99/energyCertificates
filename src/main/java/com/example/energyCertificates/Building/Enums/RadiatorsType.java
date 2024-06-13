package com.example.energyCertificates.Building.Enums;

public enum RadiatorsType {
    NULL("Brak"),
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

    public static RadiatorsType mapToEnum(String nameInPolish) {
        for (RadiatorsType enumType : RadiatorsType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
