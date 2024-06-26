package com.example.energyCertificates.Building.Enums;

public enum CeilingBelowTheFlatType {
    NULL("Brak"),
    CEILING_OVER_UNHEATED_BASEMENT("Strop nad nieogrzewaną piwnicą"),
    CEILING_OVER_HEATED_BASEMENT("Strop nad ogrzewaną piwnicą"),
    FLOOR_IN_THE_GROUND("Podłoga na grunicie");

    private String nameInPolish;

    CeilingBelowTheFlatType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static CeilingBelowTheFlatType mapToEnum(String nameInPolish) {
        for (CeilingBelowTheFlatType enumType : CeilingBelowTheFlatType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
