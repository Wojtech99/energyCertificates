package com.example.energyCertificates.Building.House.Dtoes;

import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.House.Enums.EntranceDoorType;
import com.example.energyCertificates.Data.Dtoes.DataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * DTO for {@link com.example.energyCertificates.Building.House.House}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto implements Serializable {
    private Long id;
    private String street;
    private int houseNumber;
    private int flatNumber;
    private String postalCode;
    private String city;
    private double usableArea;
    private double VolumeOfHouse;
    private int yearOfCommissioningOfTheBuilding;
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
    private VentilationType ventilationType;
    private CeilingOverTheFlatType ceilingOverTheFlatType;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private FloorNumberInTheBuilding floorNumberInTheBuilding;
    private EntranceDoorType entranceDoorType;
    private WindowFrameMaterial windowFrameMaterial;
    private NumberOfGlasses numberOfGlasses;
    private ExternalMaterialWallsType externalMaterialWallsType;
    private int externalMaterialWallsThicknessInCentimeters;
    private ExternalIsolationWallsType externalIsolationWallsType;
    private int externalIsolationWallsThicknessInCentimeters;
    private List<HouseWallDto> hauseWallDtoList;
    private boolean areThereAnyUnheatedRoomsInHouse;
    private List<UnheatedRoomDto> unheatedRoomDtoList;
    private boolean isHouseBuildCorrectly;
    private String HouseNotBuildCorrectlyInformation;
    private boolean hasHouseAirConditioning;
    private int airConditioningPowerInKw;
    private boolean hasInstalledRecuperator;
    private String recuperatorModel;
    private List<DataDto> attachmentDtoList;
    private String additionalInformation;
    private Date sendFormDate;
    private boolean certificationIsCompleted;
}