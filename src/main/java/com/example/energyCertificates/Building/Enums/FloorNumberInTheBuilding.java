package com.example.energyCertificates.Building.Enums;

public enum FloorNumberInTheBuilding {
    NULL("Brak"),
    ONE_FLOOR("Jednopoziomowe"),
    TWO_FLOOR("Dwupoziomowe"),
    THREE_FLOOR("Trzypoziomowe"),
    FOUR_FLOOR("Czteropoziomowe");

    private String nameInPolish;

    FloorNumberInTheBuilding(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static FloorNumberInTheBuilding mapToEnum(String nameInPolish) {
        for (FloorNumberInTheBuilding enumType : FloorNumberInTheBuilding.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
