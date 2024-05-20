package com.example.energyCertificates.Flat.Enums;

public enum VentilationType {
    GRAVITATIONAL("Grawitacyjna"),
    MECHANICAL_EXHAUST("Mechaniczna wywiewna"),
    MECHANICAL_SUPPLY_EXHAUST("Mechaniczna nawiewno-wywiewna");

    private String nameInPolish;

    VentilationType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
