package com.example.energyCertificates.Building.House.Enums;
public enum RoomType {
    GARAGE("Garaż"),
    ATTIC("Poddasze"),
    BASEMENT("Piwnica");

    private String nameInPolish;

    RoomType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
