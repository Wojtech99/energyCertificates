package com.example.energyCertificates.Building.House.Enums;

public enum WorldParts {
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
}
