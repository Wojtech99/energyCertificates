package com.example.energyCertificates.Building.House;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UnheatedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomType;
    private double areaInSquareM;

    public UnheatedRoom() {}

    public UnheatedRoom(int roomType, double area) {
        this.roomType = roomType;
        this.areaInSquareM = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public double getAreaInSquareM() {
        return areaInSquareM;
    }

    public void setAreaInSquareM(double areaInSquareM) {
        this.areaInSquareM = areaInSquareM;
    }
}
