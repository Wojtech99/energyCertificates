package com.example.energyCertificates.Building.Enums;

public enum ExternalMaterialWallsType {
    NULL("Brak"),
    BRICK("Cegła"),
    SILK("Silka"),
    REINFORCED_CONCRETE("Żelbet"),
    CINDER_BLOCK("Pustak żużlowy"),
    POROTHERM("Poroterm"),
    AERATED_CONCRETE("Beton komórkowy"),
    ANOTHER("Inne");

    private String nameInPolish;

    ExternalMaterialWallsType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static ExternalMaterialWallsType mapToEnum(String nameInPolish) {
        for (ExternalMaterialWallsType enumType : ExternalMaterialWallsType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
