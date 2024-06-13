package com.example.energyCertificates.Building.Enums;

public enum HeatingOfWaterType {
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
    ELECTRIC_FLOW_HEATER("Elektryczny podgrzewacz przepływowy"),
    BOILER("Elektryczny podgrzewacz pojemnościowy (bojler)"),
    SOLAR_HEATER("Podgrzewacz solarny");

    private String nameInPolish;

    HeatingOfWaterType(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    public String getNameInPolish() {
        return nameInPolish;
    }

    public static HeatingOfWaterType mapToEnum(String nameInPolish) {
        for (HeatingOfWaterType enumType : HeatingOfWaterType.values()) {
            if (enumType.getNameInPolish().equals(nameInPolish)) {
                return enumType;
            }
        }

        return null;
    }
}
