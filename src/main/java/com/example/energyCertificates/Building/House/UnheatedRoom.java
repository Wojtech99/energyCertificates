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
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public UnheatedRoom() {}

    public UnheatedRoom(RoomType roomType, double areaInSquareM, House house) {
        this.roomType = roomType;
        this.areaInSquareM = areaInSquareM;
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
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
