package com.example.energyCertificates.Building.Enums;

public enum NumberOfGlasses {
    NULL("Brak"),
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

    public static NumberOfGlasses mapToEnum(String nameInPolish) {
        for (NumberOfGlasses enumType : NumberOfGlasses.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
