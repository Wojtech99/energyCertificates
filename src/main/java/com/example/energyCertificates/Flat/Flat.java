package com.example.energyCertificates.Flat;

import com.example.energyCertificates.Flat.Enums.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Flat {
    @Id
    private Long id;
    //Basic data of the flat
    private String street;
    private int houseNumber;
    private int flatNumber;
    private String postalCode;
    private String city;
    private double usableArea;
    private double heightOfFlat;
    private int yearOfCommissioningOfTheBuilding;
    private FloorNumberInTheFlat floorNumberInTheFlat;
    private boolean TheBuildingIsAfterThermalModernization;
    private int lastBuildingThermalModernizationYear;
    private List<ThermalModernizationScope> thermalModernizationScopeList;
    private boolean flatIsAtTheGroundFloor;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private boolean flatIsAtTheLastFloor;
    private CeilingOverTheFlatType ceilingOverTheFlatType;
    //walls
    private ExternalMaterialWallsType externalMaterialWallsType;
    private int externalMaterialWallsThicknessInCentimeters;
    private ExternalIsolationWallsType externalIsolationWallsType;
    private int externalIsolationWallsThicknessInCentimeters;
    private ExternalWallLayout externalWallLayout;
    //Windows
    private WindowFrameMaterial windowFrameMaterial;
    private NumberOfGlasses numberOfGlasses;
    //Heating and Ventilation
    private HeatingType heatingType;
    private RadiatorsType radiatorsType;
    private HeatingOfWaterType heatingOfWaterType;
    private VentilationType ventilationType;
    private List<String> attachments;
    private String additionalInformation;


}
