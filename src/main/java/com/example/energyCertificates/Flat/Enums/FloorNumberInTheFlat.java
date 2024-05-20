package com.example.energyCertificates.Flat.Enums;

public enum FloorNumberInTheFlat {
    ONE_FLOOR("Jednopoziomowe"),
    TWO_FLOOR("Dwupoziomowe"),
    THREE_FLOOR("Trzypoziomowe");

    private String nameInPolish;

    FloorNumberInTheFlat(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
