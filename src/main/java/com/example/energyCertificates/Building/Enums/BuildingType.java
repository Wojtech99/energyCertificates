package com.example.energyCertificates.Building.Enums;

public enum BuildingType {
    HOUSE("Dom"),
    FLAT("Mieszkanie");

    private String nameInPolish;

    BuildingType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }


}
