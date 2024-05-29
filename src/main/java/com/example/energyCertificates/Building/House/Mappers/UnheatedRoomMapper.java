package com.example.energyCertificates.Building.House.Mappers;

import com.example.energyCertificates.Building.House.Dtoes.UnheatedRoomDto;
import com.example.energyCertificates.Building.House.UnheatedRoom;
import org.springframework.stereotype.Component;

@Component
public class UnheatedRoomMapper {
    public static UnheatedRoom map(UnheatedRoomDto unheatedRoomDto) {
        UnheatedRoom unheatedRoom = new UnheatedRoom(
                unheatedRoomDto.getRoomType(),
                unheatedRoomDto.getAreaInSquareM(),
                HouseMapper.map(unheatedRoomDto.getHouseDto())
        );

        unheatedRoom.setId(unheatedRoomDto.getId());

        return unheatedRoom;
    }

    public static UnheatedRoomDto map(UnheatedRoom unheatedRoom) {
        return new UnheatedRoomDto(
                unheatedRoom.getId(),
                unheatedRoom.getRoomType(),
                unheatedRoom.getAreaInSquareM(),
                HouseMapper.map(unheatedRoom.getHouse())
        );
    }
}
