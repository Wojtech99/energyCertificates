package com.example.energyCertificates.Building.House.Mappers;

import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.HouseWall;
import org.springframework.stereotype.Component;

@Component
public class HouseWallMapper {
    public static HouseWall map(HouseWallDto houseWallDto) {
        HouseWall houseWall = new HouseWall(
                houseWallDto.getWorldPart(),
                houseWallDto.getTotalLengthOfExternalWallInM()
        );

        houseWall.setId(houseWall.getId());

        return houseWall;
    }

    public static HouseWallDto map(HouseWall houseWall) {
        return new HouseWallDto(
                houseWall.getId(),
                houseWall.getWorldPartEnumNumber(),
                houseWall.getTotalLengthOfExternalWallInM()
        );
    }
}
