package com.example.energyCertificates.Building.Flat.Enums;

public enum ExternalWallLayout {
    NULL("Brak"),
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

    public static ExternalWallLayout mapToEnum(String nameInPolish) {
        for (ExternalWallLayout enumType : ExternalWallLayout.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
