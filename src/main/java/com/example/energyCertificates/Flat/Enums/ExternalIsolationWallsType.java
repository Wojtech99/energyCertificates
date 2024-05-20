package com.example.energyCertificates.Flat.Enums;

public enum ExternalIsolationWallsType {
    WHITE_STYROFOAM("Styropian biały"),
    GRAPHITE_STYROFOAM("Styropian grafitowy"),
    MINERAL_WOOL("Wełna mineralna"),
    NONE("Brak");

    private String nameInPolish;

    ExternalIsolationWallsType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
