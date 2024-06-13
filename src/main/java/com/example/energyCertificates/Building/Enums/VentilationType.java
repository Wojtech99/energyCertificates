package com.example.energyCertificates.Building.Enums;

public enum VentilationType {
    NULL("Brak"),
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

    public static VentilationType mapToEnum(String nameInPolish) {
        for (VentilationType enumType : VentilationType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
