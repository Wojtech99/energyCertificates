package com.example.energyCertificates.Building.Flat.Dtoes;

import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.Flat.Enums.ExternalWallLayout;
import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Data.DataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.example.energyCertificates.Building.Flat.Flat}
 */
@Data
@AllArgsConstructor
public class FlatDto implements Serializable {
    private Long id;
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
    private List<ThermalModernizationScopeClassDto> thermalModernizationScopeList;
    private boolean flatIsAtGroundFloor;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private boolean flatIsAtLastFloor;
    private CeilingOverTheFlatType ceilingOverTheFlatType;
    private ExternalMaterialWallsType externalMaterialWallsType;
    private String anotherExternalMaterialWallsType;
    private int externalMaterialWallsThicknessInCentimeters;
    private ExternalIsolationWallsType externalIsolationWallsType;
    private String anotherExternalIsolationWallsType;
    private int externalIsolationWallsThicknessInCm;
    private ExternalWallLayout externalWallLayout;
    private WindowFrameMaterial windowFrameMaterial;
    private NumberOfGlasses numberOfGlasses;
    private HeatingType heatingType;
    private RadiatorsType radiatorsType;
    private HeatingOfWaterType heatingOfWaterType;
    private VentilationType ventilationType;
    private List<DataDto> attachments;
    private String additionalInformation;
    private Date sendFormDate;
    private boolean certificationIsCompleted;
    private ClientDto clientDto;

    public FlatDto() {
        this.thermalModernizationScopeList = new ArrayList<>();
        this.attachments = new ArrayList<>();
    }
}