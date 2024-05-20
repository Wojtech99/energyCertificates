package com.example.energyCertificates.Flat.Enums;

public enum ExternalWallLayout {
    ONE_SIDED("Jednostronne"),
    TWO_SIDED("Dwustronne"),
    THREE_SIDED("Trzystronne"),
    FOUR_SIDED("Czterostronne");

    private String nameInPolish;

    ExternalWallLayout(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
