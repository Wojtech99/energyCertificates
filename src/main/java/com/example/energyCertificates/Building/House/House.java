package com.example.energyCertificates.Building.House;

import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.House.Enums.EntranceDoorType;
import com.example.energyCertificates.Client.Client;
import com.example.energyCertificates.Data.Data;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class House {
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
    private double VolumeOfHouse;
    private int yearOfCommissioningOfTheBuilding;
    //Heating
    private HeatingType heatingType;
    private String typeOfHeatingWithFurnaceModel;
    private RadiatorsType radiatorsType;
    private boolean areInstallationCablesInsulted;
    private boolean isThereHeatingCirculation;
    private boolean isThereHeatingBufferOrTank;
    private boolean isThereSecondaryHeatingType;
    private HeatingType secondaryHeatingType;
    private String secondaryTypeOfHeatingWithFurnaceModel;
    private RadiatorsType secondaryRadiatorsType;
    private boolean secondaryAreInstallationCablesInsulted;
    private boolean secondaryIsThereHeatingCirculation;
    private boolean secondaryIsThereHeatingBufferOrTank;
    private int percentOfUsageSecondaryHeatingType;
    //Hot water
    private HeatingOfWaterType heatingOfWaterType;
    private String typeOfHeatingWaterWithFurnaceModel;
    private boolean areWaterInstallationCablesInsulted;
    private boolean isThereHeatWaterCirculation;
    private boolean isThereHeatWaterBufferOrTank;
    private boolean isThereSecondaryHeatingOfWaterType;
    private HeatingOfWaterType secondaryHeatingOfWaterType;
    private String secondaryTypeOfHeatingWaterWithFurnaceModel;
    private boolean secondaryAreWaterInstallationCablesInsulted;
    private boolean secondaryIsThereHeatWaterCirculation;
    private boolean secondaryIsThereHeatWaterBufferOrTank;
    private int percentOfUsageSecondaryHeatOfWaterType;
    //Ventilation
    private VentilationType ventilationType;
    //Ceiling
    private CeilingOverTheFlatType ceilingOverTheFlatType;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private FloorNumberInTheBuilding floorNumberInTheBuilding;
    //Windows and entrance door
    private EntranceDoorType entranceDoorType;
    private WindowFrameMaterial windowFrameMaterial;
    private NumberOfGlasses numberOfGlasses;
    //Layout and type of External Walls
    private ExternalMaterialWallsType externalMaterialWallsType;
    private int externalMaterialWallsThicknessInCentimeters;
    private ExternalIsolationWallsType externalIsolationWallsType;
    private int externalIsolationWallsThicknessInCentimeters;
    @OneToMany(fetch = FetchType.EAGER)
    private List<HouseWall> hauseWallList;
    private boolean areThereAnyUnheatedRoomsInHouse;
    @OneToMany(fetch = FetchType.EAGER)
    private List<UnheatedRoom> unheatedRoomList;
    private boolean isHouseBuildCorrectly;
    private String HouseNotBuildCorrectlyInformation;
    private boolean hasHouseAirConditioning;
    private int airConditioningPowerInKw;
    private boolean hasInstalledRecuperator;
    private String recuperatorModel;
    private boolean hasSolarPanels;
    private String powerAndUsageOfSolarPanels;
    //Attachments
    @OneToMany(fetch = FetchType.EAGER)
    private List<Data> attachments;
    private String additionalInformation;
    //Other
    private Date sendFormDate;
    private boolean certificationIsCompleted;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public House() {}

    public House(String street, int houseNumber, int flatNumber, String postalCode, String city, double usableArea, double volumeOfHouse, int yearOfCommissioningOfTheBuilding, HeatingType heatingType, String typeOfHeatingWithFurnaceModel, RadiatorsType radiatorsType, boolean areInstallationCablesInsulted, boolean isThereHeatingCirculation, boolean isThereHeatingBufferOrTank, boolean isThereSecondaryHeatingType, HeatingType secondaryHeatingType, String secondaryTypeOfHeatingWithFurnaceModel, RadiatorsType secondaryRadiatorsType, boolean secondaryAreInstallationCablesInsulted, boolean secondaryIsThereHeatingCirculation, boolean secondaryIsThereHeatingBufferOrTank, int percentOfUsageSecondaryHeatingType, HeatingOfWaterType heatingOfWaterType, String typeOfHeatingWaterWithFurnaceModel, boolean areWaterInstallationCablesInsulted, boolean isThereHeatWaterCirculation, boolean isThereHeatWaterBufferOrTank, boolean isThereSecondaryHeatingOfWaterType, HeatingOfWaterType secondaryHeatingOfWaterType, String secondaryTypeOfHeatingWaterWithFurnaceModel, boolean secondaryAreWaterInstallationCablesInsulted, boolean secondaryIsThereHeatWaterCirculation, boolean secondaryIsThereHeatWaterBufferOrTank, int percentOfUsageSecondaryHeatOfWaterType, VentilationType ventilationType, CeilingOverTheFlatType ceilingOverTheFlatType, CeilingBelowTheFlatType ceilingBelowTheFlatType, FloorNumberInTheBuilding floorNumberInTheBuilding, EntranceDoorType entranceDoorType, WindowFrameMaterial windowFrameMaterial, NumberOfGlasses numberOfGlasses, ExternalMaterialWallsType externalMaterialWallsType, int externalMaterialWallsThicknessInCentimeters, ExternalIsolationWallsType externalIsolationWallsType, int externalIsolationWallsThicknessInCentimeters, List<HouseWall> hauseWallList, boolean areThereAnyUnheatedRoomsInHouse, List<UnheatedRoom> unheatedRoomList, boolean isHouseBuildCorrectly, String houseNotBuildCorrectlyInformation, boolean hasHouseAirConditioning, int airConditioningPowerInKw, boolean hasInstalledRecuperator, String recuperatorModel, boolean hasSolarPanels, String powerAndUsageOfSolarPanels, List<Data> attachments, String additionalInformation, Date sendFormDate, boolean certificationIsCompleted, Client client) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.usableArea = usableArea;
        VolumeOfHouse = volumeOfHouse;
        this.yearOfCommissioningOfTheBuilding = yearOfCommissioningOfTheBuilding;
        this.heatingType = heatingType;
        this.typeOfHeatingWithFurnaceModel = typeOfHeatingWithFurnaceModel;
        this.radiatorsType = radiatorsType;
        this.areInstallationCablesInsulted = areInstallationCablesInsulted;
        this.isThereHeatingCirculation = isThereHeatingCirculation;
        this.isThereHeatingBufferOrTank = isThereHeatingBufferOrTank;
        this.isThereSecondaryHeatingType = isThereSecondaryHeatingType;
        this.secondaryHeatingType = secondaryHeatingType;
        this.secondaryTypeOfHeatingWithFurnaceModel = secondaryTypeOfHeatingWithFurnaceModel;
        this.secondaryRadiatorsType = secondaryRadiatorsType;
        this.secondaryAreInstallationCablesInsulted = secondaryAreInstallationCablesInsulted;
        this.secondaryIsThereHeatingCirculation = secondaryIsThereHeatingCirculation;
        this.secondaryIsThereHeatingBufferOrTank = secondaryIsThereHeatingBufferOrTank;
        this.percentOfUsageSecondaryHeatingType = percentOfUsageSecondaryHeatingType;
        this.heatingOfWaterType = heatingOfWaterType;
        this.typeOfHeatingWaterWithFurnaceModel = typeOfHeatingWaterWithFurnaceModel;
        this.areWaterInstallationCablesInsulted = areWaterInstallationCablesInsulted;
        this.isThereHeatWaterCirculation = isThereHeatWaterCirculation;
        this.isThereHeatWaterBufferOrTank = isThereHeatWaterBufferOrTank;
        this.isThereSecondaryHeatingOfWaterType = isThereSecondaryHeatingOfWaterType;
        this.secondaryHeatingOfWaterType = secondaryHeatingOfWaterType;
        this.secondaryTypeOfHeatingWaterWithFurnaceModel = secondaryTypeOfHeatingWaterWithFurnaceModel;
        this.secondaryAreWaterInstallationCablesInsulted = secondaryAreWaterInstallationCablesInsulted;
        this.secondaryIsThereHeatWaterCirculation = secondaryIsThereHeatWaterCirculation;
        this.secondaryIsThereHeatWaterBufferOrTank = secondaryIsThereHeatWaterBufferOrTank;
        this.percentOfUsageSecondaryHeatOfWaterType = percentOfUsageSecondaryHeatOfWaterType;
        this.ventilationType = ventilationType;
        this.ceilingOverTheFlatType = ceilingOverTheFlatType;
        this.ceilingBelowTheFlatType = ceilingBelowTheFlatType;
        this.floorNumberInTheBuilding = floorNumberInTheBuilding;
        this.entranceDoorType = entranceDoorType;
        this.windowFrameMaterial = windowFrameMaterial;
        this.numberOfGlasses = numberOfGlasses;
        this.externalMaterialWallsType = externalMaterialWallsType;
        this.externalMaterialWallsThicknessInCentimeters = externalMaterialWallsThicknessInCentimeters;
        this.externalIsolationWallsType = externalIsolationWallsType;
        this.externalIsolationWallsThicknessInCentimeters = externalIsolationWallsThicknessInCentimeters;
        this.hauseWallList = hauseWallList;
        this.areThereAnyUnheatedRoomsInHouse = areThereAnyUnheatedRoomsInHouse;
        this.unheatedRoomList = unheatedRoomList;
        this.isHouseBuildCorrectly = isHouseBuildCorrectly;
        HouseNotBuildCorrectlyInformation = houseNotBuildCorrectlyInformation;
        this.hasHouseAirConditioning = hasHouseAirConditioning;
        this.airConditioningPowerInKw = airConditioningPowerInKw;
        this.hasInstalledRecuperator = hasInstalledRecuperator;
        this.recuperatorModel = recuperatorModel;
        this.hasSolarPanels = hasSolarPanels;
        this.powerAndUsageOfSolarPanels = powerAndUsageOfSolarPanels;
        this.attachments = attachments;
        this.additionalInformation = additionalInformation;
        this.sendFormDate = sendFormDate;
        this.certificationIsCompleted = certificationIsCompleted;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public double getVolumeOfHouse() {
        return VolumeOfHouse;
    }

    public void setVolumeOfHouse(double volumeOfHouse) {
        VolumeOfHouse = volumeOfHouse;
    }

    public int getYearOfCommissioningOfTheBuilding() {
        return yearOfCommissioningOfTheBuilding;
    }

    public void setYearOfCommissioningOfTheBuilding(int yearOfCommissioningOfTheBuilding) {
        this.yearOfCommissioningOfTheBuilding = yearOfCommissioningOfTheBuilding;
    }

    public HeatingType getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    public String getTypeOfHeatingWithFurnaceModel() {
        return typeOfHeatingWithFurnaceModel;
    }

    public void setTypeOfHeatingWithFurnaceModel(String typeOfHeatingWithFurnaceModel) {
        this.typeOfHeatingWithFurnaceModel = typeOfHeatingWithFurnaceModel;
    }

    public RadiatorsType getRadiatorsType() {
        return radiatorsType;
    }

    public void setRadiatorsType(RadiatorsType radiatorsType) {
        this.radiatorsType = radiatorsType;
    }

    public boolean isAreInstallationCablesInsulted() {
        return areInstallationCablesInsulted;
    }

    public void setAreInstallationCablesInsulted(boolean areInstallationCablesInsulted) {
        this.areInstallationCablesInsulted = areInstallationCablesInsulted;
    }

    public boolean isThereHeatingCirculation() {
        return isThereHeatingCirculation;
    }

    public void setThereHeatingCirculation(boolean thereHeatingCirculation) {
        isThereHeatingCirculation = thereHeatingCirculation;
    }

    public boolean isThereHeatingBufferOrTank() {
        return isThereHeatingBufferOrTank;
    }

    public void setThereHeatingBufferOrTank(boolean thereHeatingBufferOrTank) {
        isThereHeatingBufferOrTank = thereHeatingBufferOrTank;
    }

    public boolean isThereSecondaryHeatingType() {
        return isThereSecondaryHeatingType;
    }

    public void setThereSecondaryHeatingType(boolean thereSecondaryHeatingType) {
        isThereSecondaryHeatingType = thereSecondaryHeatingType;
    }

    public HeatingType getSecondaryHeatingType() {
        return secondaryHeatingType;
    }

    public void setSecondaryHeatingType(HeatingType secondaryHeatingType) {
        this.secondaryHeatingType = secondaryHeatingType;
    }

    public String getSecondaryTypeOfHeatingWithFurnaceModel() {
        return secondaryTypeOfHeatingWithFurnaceModel;
    }

    public void setSecondaryTypeOfHeatingWithFurnaceModel(String secondaryTypeOfHeatingWithFurnaceModel) {
        this.secondaryTypeOfHeatingWithFurnaceModel = secondaryTypeOfHeatingWithFurnaceModel;
    }

    public RadiatorsType getSecondaryRadiatorsType() {
        return secondaryRadiatorsType;
    }

    public void setSecondaryRadiatorsType(RadiatorsType secondaryRadiatorsType) {
        this.secondaryRadiatorsType = secondaryRadiatorsType;
    }

    public boolean isSecondaryAreInstallationCablesInsulted() {
        return secondaryAreInstallationCablesInsulted;
    }

    public void setSecondaryAreInstallationCablesInsulted(boolean secondaryAreInstallationCablesInsulted) {
        this.secondaryAreInstallationCablesInsulted = secondaryAreInstallationCablesInsulted;
    }

    public boolean isSecondaryIsThereHeatingCirculation() {
        return secondaryIsThereHeatingCirculation;
    }

    public void setSecondaryIsThereHeatingCirculation(boolean secondaryIsThereHeatingCirculation) {
        this.secondaryIsThereHeatingCirculation = secondaryIsThereHeatingCirculation;
    }

    public boolean isSecondaryIsThereHeatingBufferOrTank() {
        return secondaryIsThereHeatingBufferOrTank;
    }

    public void setSecondaryIsThereHeatingBufferOrTank(boolean secondaryIsThereHeatingBufferOrTank) {
        this.secondaryIsThereHeatingBufferOrTank = secondaryIsThereHeatingBufferOrTank;
    }

    public int getPercentOfUsageSecondaryHeatingType() {
        return percentOfUsageSecondaryHeatingType;
    }

    public void setPercentOfUsageSecondaryHeatingType(int percentOfUsageSecondaryHeatingType) {
        this.percentOfUsageSecondaryHeatingType = percentOfUsageSecondaryHeatingType;
    }

    public HeatingOfWaterType getHeatingOfWaterType() {
        return heatingOfWaterType;
    }

    public void setHeatingOfWaterType(HeatingOfWaterType heatingOfWaterType) {
        this.heatingOfWaterType = heatingOfWaterType;
    }

    public String getTypeOfHeatingWaterWithFurnaceModel() {
        return typeOfHeatingWaterWithFurnaceModel;
    }

    public void setTypeOfHeatingWaterWithFurnaceModel(String typeOfHeatingWaterWithFurnaceModel) {
        this.typeOfHeatingWaterWithFurnaceModel = typeOfHeatingWaterWithFurnaceModel;
    }

    public boolean isAreWaterInstallationCablesInsulted() {
        return areWaterInstallationCablesInsulted;
    }

    public void setAreWaterInstallationCablesInsulted(boolean areWaterInstallationCablesInsulted) {
        this.areWaterInstallationCablesInsulted = areWaterInstallationCablesInsulted;
    }

    public boolean isThereHeatWaterCirculation() {
        return isThereHeatWaterCirculation;
    }

    public void setThereHeatWaterCirculation(boolean thereHeatWaterCirculation) {
        isThereHeatWaterCirculation = thereHeatWaterCirculation;
    }

    public boolean isThereHeatWaterBufferOrTank() {
        return isThereHeatWaterBufferOrTank;
    }

    public void setThereHeatWaterBufferOrTank(boolean thereHeatWaterBufferOrTank) {
        isThereHeatWaterBufferOrTank = thereHeatWaterBufferOrTank;
    }

    public boolean isThereSecondaryHeatingOfWaterType() {
        return isThereSecondaryHeatingOfWaterType;
    }

    public void setThereSecondaryHeatingOfWaterType(boolean thereSecondaryHeatingOfWaterType) {
        isThereSecondaryHeatingOfWaterType = thereSecondaryHeatingOfWaterType;
    }

    public HeatingOfWaterType getSecondaryHeatingOfWaterType() {
        return secondaryHeatingOfWaterType;
    }

    public void setSecondaryHeatingOfWaterType(HeatingOfWaterType secondaryHeatingOfWaterType) {
        this.secondaryHeatingOfWaterType = secondaryHeatingOfWaterType;
    }

    public String getSecondaryTypeOfHeatingWaterWithFurnaceModel() {
        return secondaryTypeOfHeatingWaterWithFurnaceModel;
    }

    public void setSecondaryTypeOfHeatingWaterWithFurnaceModel(String secondaryTypeOfHeatingWaterWithFurnaceModel) {
        this.secondaryTypeOfHeatingWaterWithFurnaceModel = secondaryTypeOfHeatingWaterWithFurnaceModel;
    }

    public boolean isSecondaryAreWaterInstallationCablesInsulted() {
        return secondaryAreWaterInstallationCablesInsulted;
    }

    public void setSecondaryAreWaterInstallationCablesInsulted(boolean secondaryAreWaterInstallationCablesInsulted) {
        this.secondaryAreWaterInstallationCablesInsulted = secondaryAreWaterInstallationCablesInsulted;
    }

    public boolean isSecondaryIsThereHeatWaterCirculation() {
        return secondaryIsThereHeatWaterCirculation;
    }

    public void setSecondaryIsThereHeatWaterCirculation(boolean secondaryIsThereHeatWaterCirculation) {
        this.secondaryIsThereHeatWaterCirculation = secondaryIsThereHeatWaterCirculation;
    }

    public boolean isSecondaryIsThereHeatWaterBufferOrTank() {
        return secondaryIsThereHeatWaterBufferOrTank;
    }

    public void setSecondaryIsThereHeatWaterBufferOrTank(boolean secondaryIsThereHeatWaterBufferOrTank) {
        this.secondaryIsThereHeatWaterBufferOrTank = secondaryIsThereHeatWaterBufferOrTank;
    }

    public int getPercentOfUsageSecondaryHeatOfWaterType() {
        return percentOfUsageSecondaryHeatOfWaterType;
    }

    public void setPercentOfUsageSecondaryHeatOfWaterType(int percentOfUsageSecondaryHeatOfWaterType) {
        this.percentOfUsageSecondaryHeatOfWaterType = percentOfUsageSecondaryHeatOfWaterType;
    }

    public VentilationType getVentilationType() {
        return ventilationType;
    }

    public void setVentilationType(VentilationType ventilationType) {
        this.ventilationType = ventilationType;
    }

    public CeilingOverTheFlatType getCeilingOverTheFlatType() {
        return ceilingOverTheFlatType;
    }

    public void setCeilingOverTheFlatType(CeilingOverTheFlatType ceilingOverTheFlatType) {
        this.ceilingOverTheFlatType = ceilingOverTheFlatType;
    }

    public CeilingBelowTheFlatType getCeilingBelowTheFlatType() {
        return ceilingBelowTheFlatType;
    }

    public void setCeilingBelowTheFlatType(CeilingBelowTheFlatType ceilingBelowTheFlatType) {
        this.ceilingBelowTheFlatType = ceilingBelowTheFlatType;
    }

    public FloorNumberInTheBuilding getFloorNumberInTheBuilding() {
        return floorNumberInTheBuilding;
    }

    public void setFloorNumberInTheBuilding(FloorNumberInTheBuilding floorNumberInTheBuilding) {
        this.floorNumberInTheBuilding = floorNumberInTheBuilding;
    }

    public EntranceDoorType getEntranceDoorType() {
        return entranceDoorType;
    }

    public void setEntranceDoorType(EntranceDoorType entranceDoorType) {
        this.entranceDoorType = entranceDoorType;
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

    public int getExternalIsolationWallsThicknessInCentimeters() {
        return externalIsolationWallsThicknessInCentimeters;
    }

    public void setExternalIsolationWallsThicknessInCentimeters(int externalIsolationWallsThicknessInCentimeters) {
        this.externalIsolationWallsThicknessInCentimeters = externalIsolationWallsThicknessInCentimeters;
    }

    public List<HouseWall> getHauseWallList() {
        return hauseWallList;
    }

    public void setHauseWallList(List<HouseWall> hauseWallList) {
        this.hauseWallList = hauseWallList;
    }

    public boolean isAreThereAnyUnheatedRoomsInHouse() {
        return areThereAnyUnheatedRoomsInHouse;
    }

    public void setAreThereAnyUnheatedRoomsInHouse(boolean areThereAnyUnheatedRoomsInHouse) {
        this.areThereAnyUnheatedRoomsInHouse = areThereAnyUnheatedRoomsInHouse;
    }

    public List<UnheatedRoom> getUnheatedRoomList() {
        return unheatedRoomList;
    }

    public void setUnheatedRoomList(List<UnheatedRoom> unheatedRoomList) {
        this.unheatedRoomList = unheatedRoomList;
    }

    public boolean isHouseBuildCorrectly() {
        return isHouseBuildCorrectly;
    }

    public void setHouseBuildCorrectly(boolean houseBuildCorrectly) {
        isHouseBuildCorrectly = houseBuildCorrectly;
    }

    public String getHouseNotBuildCorrectlyInformation() {
        return HouseNotBuildCorrectlyInformation;
    }

    public void setHouseNotBuildCorrectlyInformation(String houseNotBuildCorrectlyInformation) {
        HouseNotBuildCorrectlyInformation = houseNotBuildCorrectlyInformation;
    }

    public boolean isHasHouseAirConditioning() {
        return hasHouseAirConditioning;
    }

    public void setHasHouseAirConditioning(boolean hasHouseAirConditioning) {
        this.hasHouseAirConditioning = hasHouseAirConditioning;
    }

    public int getAirConditioningPowerInKw() {
        return airConditioningPowerInKw;
    }

    public void setAirConditioningPowerInKw(int airConditioningPowerInKw) {
        this.airConditioningPowerInKw = airConditioningPowerInKw;
    }

    public boolean isHasInstalledRecuperator() {
        return hasInstalledRecuperator;
    }

    public void setHasInstalledRecuperator(boolean hasInstalledRecuperator) {
        this.hasInstalledRecuperator = hasInstalledRecuperator;
    }

    public String getRecuperatorModel() {
        return recuperatorModel;
    }

    public void setRecuperatorModel(String recuperatorModel) {
        this.recuperatorModel = recuperatorModel;
    }

    public boolean isHasSolarPanels() {
        return hasSolarPanels;
    }

    public void setHasSolarPanels(boolean hasSolarPanels) {
        this.hasSolarPanels = hasSolarPanels;
    }

    public String getPowerAndUsageOfSolarPanels() {
        return powerAndUsageOfSolarPanels;
    }

    public void setPowerAndUsageOfSolarPanels(String powerAndUsageOfSolarPanels) {
        this.powerAndUsageOfSolarPanels = powerAndUsageOfSolarPanels;
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
