package com.example.energyCertificates.Flat.Enums;

public enum NumberOfGlasses {
    SINGLE_CHAMBER("Jednokomorowe"),
    TWO_CHAMBER("Dwukomorowe"),
    THREE_CHAMBER("Trzykomorowe"),
    FOUR_CHAMBER("Czterokomorowe");

    private String nameInPolish;

    NumberOfGlasses(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
