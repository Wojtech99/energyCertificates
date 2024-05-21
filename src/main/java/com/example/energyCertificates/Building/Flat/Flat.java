package com.example.energyCertificates.Flat;

import com.example.energyCertificates.Data.Data;
import com.example.energyCertificates.Flat.Enums.*;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private FloorNumberInTheBuilding floorNumberInTheBuilding;
    private boolean TheBuildingIsAfterThermalModernization;
    private int lastBuildingThermalModernizationYear;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ThermalModernizationScopeClass> thermalModernizationScopeList;
    private boolean flatIsAtTheGroundFloor;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private boolean flatIsAtTheLastFloor;
    private CeilingOverTheFlatType ceilingOverTheFlatType;
    //walls
    private ExternalMaterialWallsType externalMaterialWallsType;
    private int externalMaterialWallsThicknessInCentimeters;
    private ExternalIsolationWallsType externalIsolationWallsType;
    private int externalIsolationWallsThicknessInCm;
    private ExternalWallLayout externalWallLayout;
    //Windows
    private WindowFrameMaterial windowFrameMaterial;
    private NumberOfGlasses numberOfGlasses;
    //Heating and Ventilation
    private HeatingType heatingType;
    private RadiatorsType radiatorsType;
    private HeatingOfWaterType heatingOfWaterType;
    private VentilationType ventilationType;
    //Attachments
    @OneToMany(fetch = FetchType.EAGER)
    private List<Data> attachments;
    private String additionalInformation;
    //Other
    private Date sendFormDate;
    private boolean certificationIsCompleted;


}
