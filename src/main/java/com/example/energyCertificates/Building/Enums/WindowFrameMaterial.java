package com.example.energyCertificates.Building.Enums;

public enum WindowFrameMaterial {
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
}
