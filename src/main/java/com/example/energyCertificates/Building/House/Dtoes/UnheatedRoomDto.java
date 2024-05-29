package com.example.energyCertificates.Building.House.Dtoes;

import com.example.energyCertificates.Building.House.Enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

/**
 * DTO for {@link com.example.energyCertificates.Building.House.UnheatedRoom}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnheatedRoomDto implements Serializable {
    private Long id;
    private RoomType roomType;
    private double areaInSquareM;
    private HouseDto houseDto;
}