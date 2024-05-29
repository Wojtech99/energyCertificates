package com.example.energyCertificates.Building.House;

import com.example.energyCertificates.Building.House.Enums.WorldParts;
import jakarta.persistence.*;

@Entity
public class HouseWall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private WorldParts worldPartEnumNumber;
    private double totalLengthOfExternalWallInM;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public HouseWall() {}

    public HouseWall(WorldParts worldPartEnumNumber, double totalLengthOfExternalWallInM, House house) {
        this.worldPartEnumNumber = worldPartEnumNumber;
        this.totalLengthOfExternalWallInM = totalLengthOfExternalWallInM;
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

    public WorldParts getWorldPartEnumNumber() {
        return worldPartEnumNumber;
    }

    public void setWorldPartEnumNumber(WorldParts worldPartEnumNumber) {
        this.worldPartEnumNumber = worldPartEnumNumber;
    }

    public double getTotalLengthOfExternalWallInM() {
        return totalLengthOfExternalWallInM;
    }

    public void setTotalLengthOfExternalWallInM(double totalLengthOfExternalWallInM) {
        this.totalLengthOfExternalWallInM = totalLengthOfExternalWallInM;
    }
}
