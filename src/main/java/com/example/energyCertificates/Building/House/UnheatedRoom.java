package com.example.energyCertificates.Building.House;

import com.example.energyCertificates.Building.House.Enums.RoomType;
import jakarta.persistence.*;

@Entity
public class UnheatedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RoomType roomType;
    private double areaInSquareM;

    public UnheatedRoom() {}

    public UnheatedRoom(RoomType roomType, double areaInSquareM) {
        this.roomType = roomType;
        this.areaInSquareM = areaInSquareM;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getAreaInSquareM() {
        return areaInSquareM;
    }

    public void setAreaInSquareM(double areaInSquareM) {
        this.areaInSquareM = areaInSquareM;
    }
}
