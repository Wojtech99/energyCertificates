package com.example.energyCertificates.Building.House;

import com.example.energyCertificates.Building.House.Enums.RoomType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UnheatedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RoomType roomType;
    private double areaInSquareM;

    public UnheatedRoom() {}

    public UnheatedRoom(RoomType roomType, double area) {
        this.roomType = roomType;
        this.areaInSquareM = area;
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
