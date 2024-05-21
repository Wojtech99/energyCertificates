package com.example.energyCertificates.Building.House;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HouseWall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int worldPartEnumNumber;
    private double totalLengthOfExternalWallInM;

    public HouseWall() {}

    public HouseWall(int worldPartEnumNumber, double totalLengthOfExternalWallInM) {
        this.worldPartEnumNumber = worldPartEnumNumber;
        this.totalLengthOfExternalWallInM = totalLengthOfExternalWallInM;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWorldPartEnumNumber() {
        return worldPartEnumNumber;
    }

    public void setWorldPartEnumNumber(int worldPartEnumNumber) {
        this.worldPartEnumNumber = worldPartEnumNumber;
    }

    public double getTotalLengthOfExternalWallInM() {
        return totalLengthOfExternalWallInM;
    }

    public void setTotalLengthOfExternalWallInM(double totalLengthOfExternalWallInM) {
        this.totalLengthOfExternalWallInM = totalLengthOfExternalWallInM;
    }
}
