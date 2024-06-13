package com.example.energyCertificates.Building;

import com.example.energyCertificates.Building.Enums.BuildingType;
import com.example.energyCertificates.Building.Flat.Dtoes.FlatDto;
import com.example.energyCertificates.Building.House.Dtoes.HouseDto;

public class BuildingMapper {
    public static BuildingDto map(HouseDto houseDto) {
        return new BuildingDto(
                houseDto.getSendFormDate(),
                houseDto.getCity(),
                houseDto.getStreet(),
                houseDto.getHouseNumber(),
                houseDto.getPostalCode(),
                BuildingType.HOUSE
        );
    }

    public static BuildingDto map(FlatDto flatDto) {
        return new BuildingDto(
                flatDto.getSendFormDate(),
                flatDto.getCity(),
                flatDto.getStreet(),
                flatDto.getHouseNumber(),
                flatDto.getPostalCode(),
                BuildingType.FLAT
        );
    }
}
