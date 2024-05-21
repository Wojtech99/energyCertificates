package com.example.energyCertificates.Building.House.Enums;

public enum WorldParts {
    NORTH("Północ"),
    SOUTH("Południe"),
    WEST("Zachód"),
    EAST("Wschód"),
    NORTH_EAST("Północny wschód"),
    SOUTH_EAST("Południowy wschód"),
    NORTH_WEST("Północny zachód"),
    SOUTH_WEST("Południowy zachód");

    private String nameInPolish;

    WorldParts(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }
}
