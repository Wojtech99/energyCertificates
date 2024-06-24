package com.example.energyCertificates.Building.House.Mappers;

import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.Enums.WorldParts;
import com.example.energyCertificates.Building.House.HouseWall;
import org.springframework.stereotype.Component;

@Component
public class HouseWallMapper {
    public static HouseWall map(HouseWallDto houseWallDto) {
        if (!houseWallDto.getWorldPart().equals(WorldParts.NULL)) {
            HouseWall houseWall = new HouseWall(
                    houseWallDto.getWorldPart(),
                    houseWallDto.getTotalLengthOfExternalWallInM()
            );

            houseWall.setId(houseWallDto.getId());

            return houseWall;
        }

        return null;
    }

    public static HouseWallDto map(HouseWall houseWall) {
        return new HouseWallDto(
                houseWall.getId(),
                houseWall.getWorldPartEnumNumber(),
                houseWall.getTotalLengthOfExternalWallInM()
        );
    }
}
