package com.example.energyCertificates.Building.Enums;

public enum HeatingType {
    NULL("Brak"),
    DISTRICT_HEATING("Ogrzewanie miejskie"),
    GAS_BOILER_IN_THE_APARTMENT("Kocioł gazowy w mieszkaniu"),
    GAS_BOILER_IN_THE_BOILER_ROOM_OF_THE_BUILDING("Kocioł gazowy w kotłowni w budynku"),
    COAL_BOILER("Kocioł węglowy"),
    ECO_PEA_COAL_BOILER("Kocioł na ekogroszek"),
    BIOMASS_BOILER("Kocioł na biomasę (drewno, brykiet, pellet, słoma)"),
    OIL_BOILER("Kocioł olejowy"),
    HEAT_PUMP("Pompa ciepła"),
    TILE_STOVE("Piec kaflowy"),
    ELECTRIC_HEATING("Ogrzewanie elektryczne");

    private String nameInPolish;

    HeatingType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static HeatingType mapToEnum(String nameInPolish) {
        for (HeatingType enumType : HeatingType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
