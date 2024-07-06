package com.example.energyCertificates.Building.Enums;

public enum ExternalIsolationWallsType {
    NULL("Brak"),
    WHITE_STYROFOAM("Styropian biały"),
    GRAPHITE_STYROFOAM("Styropian grafitowy"),
    MINERAL_WOOL("Wełna mineralna"),
    ANOTHER("Inne");

    private String nameInPolish;

    ExternalIsolationWallsType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static ExternalIsolationWallsType mapToEnum(String nameInPolish) {
        for (ExternalIsolationWallsType enumType : ExternalIsolationWallsType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
