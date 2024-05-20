package com.example.energyCertificates.Flat.Enums;

public enum ExternalMaterialWallsType {
    BRICK("Cegła"),
    SILK("Silka"),
    REINFORCED_CONCRETE("Żelbet"),
    CINDER_BLOCK("Pustak żużlowy"),
    POROTHERM("Poroterm"),
    AERATED__CONCRETE("Beton komórkowy");

    private String nameInPolish;

    ExternalMaterialWallsType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
