package com.example.energyCertificates.Building.Enums;

public enum FloorNumberInTheBuilding {
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
}
