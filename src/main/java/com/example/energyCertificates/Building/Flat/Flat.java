package com.example.energyCertificates.Building.Flat;

import com.example.energyCertificates.Data.Data;
import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.Flat.Enums.*;

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
    private FloorNumberInTheBuilding floorNumberInBuilding;
    private boolean TheBuildingIsAfterThermalModernization;
    private int lastBuildingThermalModernizationYear;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ThermalModernizationScopeClass> thermalModernizationScopeList;
    private boolean flatIsAtGroundFloor;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private boolean flatIsAtLastFloor;
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

    public Flat() {}

    public Flat(String street, int houseNumber, int flatNumber, String postalCode, String city, double usableArea, double heightOfFlat, int yearOfCommissioningOfTheBuilding, FloorNumberInTheBuilding floorNumberInBuilding, boolean theBuildingIsAfterThermalModernization, int lastBuildingThermalModernizationYear, List<ThermalModernizationScopeClass> thermalModernizationScopeList, boolean flatIsAtGroundFloor, CeilingBelowTheFlatType ceilingBelowTheFlatType, boolean flatIsAtLastFloor, CeilingOverTheFlatType ceilingOverTheFlatType, ExternalMaterialWallsType externalMaterialWallsType, int externalMaterialWallsThicknessInCentimeters, ExternalIsolationWallsType externalIsolationWallsType, int externalIsolationWallsThicknessInCm, ExternalWallLayout externalWallLayout, WindowFrameMaterial windowFrameMaterial, NumberOfGlasses numberOfGlasses, HeatingType heatingType, RadiatorsType radiatorsType, HeatingOfWaterType heatingOfWaterType, VentilationType ventilationType, List<Data> attachments, String additionalInformation, Date sendFormDate, boolean certificationIsCompleted) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.usableArea = usableArea;
        this.heightOfFlat = heightOfFlat;
        this.yearOfCommissioningOfTheBuilding = yearOfCommissioningOfTheBuilding;
        this.floorNumberInBuilding = floorNumberInBuilding;
        TheBuildingIsAfterThermalModernization = theBuildingIsAfterThermalModernization;
        this.lastBuildingThermalModernizationYear = lastBuildingThermalModernizationYear;
        this.thermalModernizationScopeList = thermalModernizationScopeList;
        this.flatIsAtGroundFloor = flatIsAtGroundFloor;
        this.ceilingBelowTheFlatType = ceilingBelowTheFlatType;
        this.flatIsAtLastFloor = flatIsAtLastFloor;
        this.ceilingOverTheFlatType = ceilingOverTheFlatType;
        this.externalMaterialWallsType = externalMaterialWallsType;
        this.externalMaterialWallsThicknessInCentimeters = externalMaterialWallsThicknessInCentimeters;
        this.externalIsolationWallsType = externalIsolationWallsType;
        this.externalIsolationWallsThicknessInCm = externalIsolationWallsThicknessInCm;
        this.externalWallLayout = externalWallLayout;
        this.windowFrameMaterial = windowFrameMaterial;
        this.numberOfGlasses = numberOfGlasses;
        this.heatingType = heatingType;
        this.radiatorsType = radiatorsType;
        this.heatingOfWaterType = heatingOfWaterType;
        this.ventilationType = ventilationType;
        this.attachments = attachments;
        this.additionalInformation = additionalInformation;
        this.sendFormDate = sendFormDate;
        this.certificationIsCompleted = certificationIsCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getHeightOfFlat() {
        return heightOfFlat;
    }

    public void setHeightOfFlat(double heightOfFlat) {
        this.heightOfFlat = heightOfFlat;
    }

    public int getYearOfCommissioningOfTheBuilding() {
        return yearOfCommissioningOfTheBuilding;
    }

    public void setYearOfCommissioningOfTheBuilding(int yearOfCommissioningOfTheBuilding) {
        this.yearOfCommissioningOfTheBuilding = yearOfCommissioningOfTheBuilding;
    }

    public FloorNumberInTheBuilding getFloorNumberInBuilding() {
        return floorNumberInBuilding;
    }

    public void setFloorNumberInBuilding(FloorNumberInTheBuilding floorNumberInBuilding) {
        this.floorNumberInBuilding = floorNumberInBuilding;
    }

    public boolean isTheBuildingIsAfterThermalModernization() {
        return TheBuildingIsAfterThermalModernization;
    }

    public void setTheBuildingIsAfterThermalModernization(boolean theBuildingIsAfterThermalModernization) {
        TheBuildingIsAfterThermalModernization = theBuildingIsAfterThermalModernization;
    }

    public int getLastBuildingThermalModernizationYear() {
        return lastBuildingThermalModernizationYear;
    }

    public void setLastBuildingThermalModernizationYear(int lastBuildingThermalModernizationYear) {
        this.lastBuildingThermalModernizationYear = lastBuildingThermalModernizationYear;
    }

    public List<ThermalModernizationScopeClass> getThermalModernizationScopeList() {
        return thermalModernizationScopeList;
    }

    public void setThermalModernizationScopeList(List<ThermalModernizationScopeClass> thermalModernizationScopeList) {
        this.thermalModernizationScopeList = thermalModernizationScopeList;
    }

    public boolean isFlatIsAtGroundFloor() {
        return flatIsAtGroundFloor;
    }

    public void setFlatIsAtGroundFloor(boolean flatIsAtGroundFloor) {
        this.flatIsAtGroundFloor = flatIsAtGroundFloor;
    }

    public CeilingBelowTheFlatType getCeilingBelowTheFlatType() {
        return ceilingBelowTheFlatType;
    }

    public void setCeilingBelowTheFlatType(CeilingBelowTheFlatType ceilingBelowTheFlatType) {
        this.ceilingBelowTheFlatType = ceilingBelowTheFlatType;
    }

    public boolean isFlatIsAtLastFloor() {
        return flatIsAtLastFloor;
    }

    public void setFlatIsAtLastFloor(boolean flatIsAtLastFloor) {
        this.flatIsAtLastFloor = flatIsAtLastFloor;
    }

    public CeilingOverTheFlatType getCeilingOverTheFlatType() {
        return ceilingOverTheFlatType;
    }

    public void setCeilingOverTheFlatType(CeilingOverTheFlatType ceilingOverTheFlatType) {
        this.ceilingOverTheFlatType = ceilingOverTheFlatType;
    }

    public ExternalMaterialWallsType getExternalMaterialWallsType() {
        return externalMaterialWallsType;
    }

    public void setExternalMaterialWallsType(ExternalMaterialWallsType externalMaterialWallsType) {
        this.externalMaterialWallsType = externalMaterialWallsType;
    }

    public int getExternalMaterialWallsThicknessInCentimeters() {
        return externalMaterialWallsThicknessInCentimeters;
    }

    public void setExternalMaterialWallsThicknessInCentimeters(int externalMaterialWallsThicknessInCentimeters) {
        this.externalMaterialWallsThicknessInCentimeters = externalMaterialWallsThicknessInCentimeters;
    }

    public ExternalIsolationWallsType getExternalIsolationWallsType() {
        return externalIsolationWallsType;
    }

    public void setExternalIsolationWallsType(ExternalIsolationWallsType externalIsolationWallsType) {
        this.externalIsolationWallsType = externalIsolationWallsType;
    }

    public int getExternalIsolationWallsThicknessInCm() {
        return externalIsolationWallsThicknessInCm;
    }

    public void setExternalIsolationWallsThicknessInCm(int externalIsolationWallsThicknessInCm) {
        this.externalIsolationWallsThicknessInCm = externalIsolationWallsThicknessInCm;
    }

    public ExternalWallLayout getExternalWallLayout() {
        return externalWallLayout;
    }

    public void setExternalWallLayout(ExternalWallLayout externalWallLayout) {
        this.externalWallLayout = externalWallLayout;
    }

    public WindowFrameMaterial getWindowFrameMaterial() {
        return windowFrameMaterial;
    }

    public void setWindowFrameMaterial(WindowFrameMaterial windowFrameMaterial) {
        this.windowFrameMaterial = windowFrameMaterial;
    }

    public NumberOfGlasses getNumberOfGlasses() {
        return numberOfGlasses;
    }

    public void setNumberOfGlasses(NumberOfGlasses numberOfGlasses) {
        this.numberOfGlasses = numberOfGlasses;
    }

    public HeatingType getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    public RadiatorsType getRadiatorsType() {
        return radiatorsType;
    }

    public void setRadiatorsType(RadiatorsType radiatorsType) {
        this.radiatorsType = radiatorsType;
    }

    public HeatingOfWaterType getHeatingOfWaterType() {
        return heatingOfWaterType;
    }

    public void setHeatingOfWaterType(HeatingOfWaterType heatingOfWaterType) {
        this.heatingOfWaterType = heatingOfWaterType;
    }

    public VentilationType getVentilationType() {
        return ventilationType;
    }

    public void setVentilationType(VentilationType ventilationType) {
        this.ventilationType = ventilationType;
    }

    public List<Data> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Data> attachments) {
        this.attachments = attachments;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Date getSendFormDate() {
        return sendFormDate;
    }

    public void setSendFormDate(Date sendFormDate) {
        this.sendFormDate = sendFormDate;
    }

    public boolean isCertificationIsCompleted() {
        return certificationIsCompleted;
    }

    public void setCertificationIsCompleted(boolean certificationIsCompleted) {
        this.certificationIsCompleted = certificationIsCompleted;
    }
}
