package com.example.energyCertificates.Building.Enums;

public enum CeilingOverTheFlatType {
    NULL("Brak"),
    THE_CEILING_IS_UNDER_AN_UNHEATED_ATTIC("Strop jest pod nieogrzewanym poddaszem"),
    FLAT_ROOF_SOFFIT("Dach płaski (stropodach)"),
    INSULATED_PITCHED_ROOF("Dach spadzisty ocieplony"),
    NOT_INSULATED_PITCHED_ROOF("Dach spadzisty nieocieplony");

    private String nameInPolish;

    CeilingOverTheFlatType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static CeilingOverTheFlatType mapToEnum(String nameInPolish) {
        for (CeilingOverTheFlatType enumType : CeilingOverTheFlatType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
