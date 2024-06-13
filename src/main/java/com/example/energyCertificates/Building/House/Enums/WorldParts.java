package com.example.energyCertificates.Building.House.Enums;

import com.example.energyCertificates.Building.Enums.ExternalIsolationWallsType;

public enum WorldParts {
    NULL("Brak"),
    NORTH("Północ"),
    SOUTH("Południe"),
    EAST("Wschód"),
    WEST("Zachód"),
    NORTH_EAST("Północny wschód"),
    NORTH_WEST("Południowy wschód"),
    SOUTH_EAST("Północny zachód"),
    SOUTH_WEST("Południowy zachód");

    private String nameInPolish;

    WorldParts(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static WorldParts mapToEnum(String nameInPolish) {
        for (WorldParts enumType : WorldParts.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
