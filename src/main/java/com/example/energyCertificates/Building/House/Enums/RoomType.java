package com.example.energyCertificates.Building.House.Enums;

public enum RoomType {
    NULL("Brak"),
    GARAGE("Garaż"),
    ATTIC("Poddasze"),
    BASEMENT("Piwnica"),
    BOILER_OR_UTILITY_ROOM("Kotłownia/Pomieszczenie gospodarcze");


    private String nameInPolish;

    RoomType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static RoomType mapToEnum(String nameInPolish) {
        for (RoomType enumType : RoomType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
