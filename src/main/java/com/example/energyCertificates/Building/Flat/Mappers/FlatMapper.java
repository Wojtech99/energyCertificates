package com.example.energyCertificates.Building.Flat.Mappers;

import com.example.energyCertificates.Building.Flat.Dtoes.FlatDto;
import com.example.energyCertificates.Building.Flat.Dtoes.ThermalModernizationScopeClassDto;
import com.example.energyCertificates.Building.Flat.Flat;
import com.example.energyCertificates.Building.Flat.ThermalModernizationScopeClass;
import com.example.energyCertificates.Client.ClientMapper;
import com.example.energyCertificates.Data.Data;
import com.example.energyCertificates.Data.DataMapper;
import com.example.energyCertificates.Data.DataDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlatMapper {
    public static Flat map(FlatDto flatDto) {
        List<DataDto> dataDtos = flatDto.getAttachments();
        List<ThermalModernizationScopeClassDto> thermalDtos = flatDto.getThermalModernizationScopeList();

        List<Data> datas = dataDtos.stream().map(DataMapper::map).toList();
        List<ThermalModernizationScopeClass> thermals = thermalDtos.stream().map(ThermalModernizationMapper::map).toList();

        Flat flat = new Flat(
                flatDto.getStreet(),
                flatDto.getHouseNumber(),
                flatDto.getFlatNumber(),
                flatDto.getPostalCode(),
                flatDto.getCity(),
                flatDto.getUsableArea(),
                flatDto.getHeightOfFlat(),
                flatDto.getYearOfCommissioningOfTheBuilding(),
                flatDto.getFloorNumberInBuilding(),
                flatDto.isTheBuildingIsAfterThermalModernization(),
                flatDto.getLastBuildingThermalModernizationYear(),
                thermals,
                flatDto.isFlatIsAtGroundFloor(),
                flatDto.getCeilingBelowTheFlatType(),
                flatDto.isFlatIsAtLastFloor(),
                flatDto.getCeilingOverTheFlatType(),

                flatDto.getExternalMaterialWallsType(),
                flatDto.getExternalMaterialWallsThicknessInCentimeters(),
                flatDto.getExternalIsolationWallsType(),
                flatDto.getExternalIsolationWallsThicknessInCm(),
                flatDto.getExternalWallLayout(),

                flatDto.getWindowFrameMaterial(),
                flatDto.getNumberOfGlasses(),

                flatDto.getHeatingType(),
                flatDto.getRadiatorsType(),
                flatDto.getHeatingOfWaterType(),
                flatDto.getVentilationType(),

                datas,
                flatDto.getAdditionalInformation(),

                flatDto.getSendFormDate(),
                flatDto.isCertificationIsCompleted(),
                ClientMapper.map(flatDto.getClientDto())
        );

        flat.setId(flatDto.getId());

        return flat;
    }

    public static FlatDto map(Flat flat) {
        List<Data> datas = flat.getAttachments();
        List<ThermalModernizationScopeClass> thermals = flat.getThermalModernizationScopeList();

        List<DataDto> dataDtos = datas.stream().map(DataMapper::map).toList();
        List<ThermalModernizationScopeClassDto> thermalsDto = thermals.stream().map(ThermalModernizationMapper::map).toList();

        return new FlatDto(
                flat.getId(),
                flat.getStreet(),
                flat.getHouseNumber(),
                flat.getFlatNumber(),
                flat.getPostalCode(),
                flat.getCity(),
                flat.getUsableArea(),
                flat.getHeightOfFlat(),
                flat.getYearOfCommissioningOfTheBuilding(),
                flat.getFloorNumberInBuilding(),
                flat.isTheBuildingIsAfterThermalModernization(),
                flat.getLastBuildingThermalModernizationYear(),
                thermalsDto,
                flat.isFlatIsAtGroundFloor(),
                flat.getCeilingBelowTheFlatType(),
                flat.isFlatIsAtLastFloor(),
                flat.getCeilingOverTheFlatType(),

                flat.getExternalMaterialWallsType(),
                flat.getExternalMaterialWallsThicknessInCentimeters(),
                flat.getExternalIsolationWallsType(),
                flat.getExternalIsolationWallsThicknessInCm(),
                flat.getExternalWallLayout(),

                flat.getWindowFrameMaterial(),
                flat.getNumberOfGlasses(),

                flat.getHeatingType(),
                flat.getRadiatorsType(),
                flat.getHeatingOfWaterType(),
                flat.getVentilationType(),

                dataDtos,
                flat.getAdditionalInformation(),

                flat.getSendFormDate(),
                flat.isCertificationIsCompleted(),
                ClientMapper.map(flat.getClient())
        );
    }
}
