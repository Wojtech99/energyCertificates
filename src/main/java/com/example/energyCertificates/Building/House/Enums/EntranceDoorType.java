package com.example.energyCertificates.Building.House.Enums;

import com.example.energyCertificates.Building.Enums.FloorNumberInTheBuilding;

public enum EntranceDoorType {
    NULL("Brak"),
    PVC("PVC"),
    WOODEN("Drewniane"),
    ALUMINUM("Aluminiowe"),
    STEEL("Stalowe");

    private String nameInPolish;

    EntranceDoorType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static EntranceDoorType mapToEnum(String nameInPolish) {
        for (EntranceDoorType enumType : EntranceDoorType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
