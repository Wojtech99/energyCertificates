package com.example.energyCertificates.Building.Enums;

import com.example.energyCertificates.Building.House.Enums.EntranceDoorType;

public enum WindowFrameMaterial {
    NULL("Brak"),
    PVC("PVC"),
    WOODEN("Drewniane"),
    ALUMINUM("Aluminiowe");

    private String nameInPolish;

    WindowFrameMaterial(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static WindowFrameMaterial mapToEnum(String nameInPolish) {
        for (WindowFrameMaterial enumType : WindowFrameMaterial.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
