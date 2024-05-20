package com.example.energyCertificates.Flat.Enums;

public enum CeilingBelowTheFlatType {
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
}
