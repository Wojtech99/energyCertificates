package com.example.energyCertificates.House.Enums;

public enum EntranceDoorType {
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
}
