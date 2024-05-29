package com.example.energyCertificates.Building.House.Dtoes;

import com.example.energyCertificates.Building.House.Enums.WorldParts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.energyCertificates.Building.House.HouseWall}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseWallDto implements Serializable {
    private Long id;
    private WorldParts worldPart;
    private double totalLengthOfExternalWallInM;
    private HouseDto houseDto;
}