package com.example.energyCertificates.Building.House.Mappers;

import com.example.energyCertificates.Building.House.Dtoes.HouseDto;
import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.Dtoes.UnheatedRoomDto;
import com.example.energyCertificates.Building.House.House;
import com.example.energyCertificates.Building.House.HouseWall;
import com.example.energyCertificates.Building.House.UnheatedRoom;
import com.example.energyCertificates.Data.Data;
import com.example.energyCertificates.Data.DataMapper;
import com.example.energyCertificates.Data.DataDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseMapper {

    public static House map(HouseDto houseDto) {
        List<HouseWallDto> houseWallDtos = houseDto.getHauseWallDtoList();
        List<UnheatedRoomDto> unheatedRoomDtos = houseDto.getUnheatedRoomDtoList();
        List<DataDto> dataDtos = houseDto.getAttachmentDtoList();

        List<HouseWall> houseWalls = houseWallDtos.stream().map(HouseWallMapper::map).toList();
        List<UnheatedRoom> unheatedRooms = unheatedRoomDtos.stream().map(UnheatedRoomMapper::map).toList();
        List<Data> datas = dataDtos.stream().map(DataMapper::map).toList();


        House house = new House(
                houseDto.getStreet(),
                houseDto.getHouseNumber(),
                houseDto.getFlatNumber(),
                houseDto.getPostalCode(),
                houseDto.getCity(),
                houseDto.getUsableArea(),
                houseDto.getVolumeOfHouse(),
                houseDto.getYearOfCommissioningOfTheBuilding(),

                houseDto.getHeatingType(),
                houseDto.getTypeOfHeatingWithFurnaceModel(),
                houseDto.getRadiatorsType(),
                houseDto.isAreInstallationCablesInsulted(),
                houseDto.isThereHeatingCirculation(),
                houseDto.isThereHeatingBufferOrTank(),
                houseDto.isThereSecondaryHeatingType(),
                houseDto.getSecondaryHeatingType(),
                houseDto.getSecondaryTypeOfHeatingWithFurnaceModel(),
                houseDto.getSecondaryRadiatorsType(),
                houseDto.isSecondaryAreInstallationCablesInsulted(),
                houseDto.isSecondaryIsThereHeatingCirculation(),
                houseDto.isSecondaryIsThereHeatingBufferOrTank(),
                houseDto.getPercentOfUsageSecondaryHeatingType(),

                houseDto.getHeatingOfWaterType(),
                houseDto.getTypeOfHeatingWaterWithFurnaceModel(),
                houseDto.isAreWaterInstallationCablesInsulted(),
                houseDto.isThereHeatWaterCirculation(),
                houseDto.isThereHeatWaterBufferOrTank(),
                houseDto.isThereSecondaryHeatingOfWaterType(),
                houseDto.getSecondaryHeatingOfWaterType(),
                houseDto.getSecondaryTypeOfHeatingWaterWithFurnaceModel(),
                houseDto.isSecondaryAreWaterInstallationCablesInsulted(),
                houseDto.isSecondaryIsThereHeatWaterCirculation(),
                houseDto.isSecondaryIsThereHeatWaterBufferOrTank(),

                houseDto.getVentilationType(),

                houseDto.getCeilingOverTheFlatType(),
                houseDto.getCeilingBelowTheFlatType(),
                houseDto.getFloorNumberInTheBuilding(),

                houseDto.getEntranceDoorType(),
                houseDto.getWindowFrameMaterial(),
                houseDto.getNumberOfGlasses(),

                houseDto.getExternalMaterialWallsType(),
                houseDto.getExternalMaterialWallsThicknessInCentimeters(),
                houseDto.getExternalIsolationWallsType(),
                houseDto.getExternalIsolationWallsThicknessInCentimeters(),
                houseWalls,
                houseDto.isAreThereAnyUnheatedRoomsInHouse(),
                unheatedRooms,
                houseDto.isHouseBuildCorrectly(),
                houseDto.getHouseNotBuildCorrectlyInformation(),
                houseDto.isHasHouseAirConditioning(),
                houseDto.getAirConditioningPowerInKw(),
                houseDto.isHasInstalledRecuperator(),
                houseDto.getRecuperatorModel(),

                datas,
                houseDto.getAdditionalInformation(),
                houseDto.getSendFormDate(),
                houseDto.isCertificationIsCompleted()
        );

        house.setId(houseDto.getId());

        return house;
    }

    public static HouseDto map(House house) {
        List<HouseWall> houseWall = house.getHauseWallList();
        List<UnheatedRoom> unheatedRoom = house.getUnheatedRoomList();
        List<Data> datas = house.getAttachments();

        List<HouseWallDto> houseWallDtoss = houseWall.stream().map(HouseWallMapper::map).toList();
        List<UnheatedRoomDto> unheatedRoomDtoss = unheatedRoom.stream().map(UnheatedRoomMapper::map).toList();
        List<DataDto> dataDtoss = datas.stream().map(DataMapper::map).toList();


       return new HouseDto(
                house.getId(),
                house.getStreet(),
                house.getHouseNumber(),
                house.getFlatNumber(),
                house.getPostalCode(),
                house.getCity(),
                house.getUsableArea(),
                house.getVolumeOfHouse(),
                house.getYearOfCommissioningOfTheBuilding(),

                house.getHeatingType(),
                house.getTypeOfHeatingWithFurnaceModel(),
                house.getRadiatorsType(),
                house.isAreInstallationCablesInsulted(),
                house.isThereHeatingCirculation(),
                house.isThereHeatingBufferOrTank(),
                house.isThereSecondaryHeatingType(),
                house.getSecondaryHeatingType(),
                house.getSecondaryTypeOfHeatingWithFurnaceModel(),
                house.getSecondaryRadiatorsType(),
                house.isSecondaryAreInstallationCablesInsulted(),
                house.isSecondaryIsThereHeatingCirculation(),
                house.isSecondaryIsThereHeatingBufferOrTank(),
                house.getPercentOfUsageSecondaryHeatingType(),

                house.getHeatingOfWaterType(),
                house.getTypeOfHeatingWaterWithFurnaceModel(),
                house.isAreWaterInstallationCablesInsulted(),
                house.isThereHeatWaterCirculation(),
                house.isThereHeatWaterBufferOrTank(),
                house.isThereSecondaryHeatingOfWaterType(),
                house.getSecondaryHeatingOfWaterType(),
                house.getSecondaryTypeOfHeatingWaterWithFurnaceModel(),
                house.isSecondaryAreWaterInstallationCablesInsulted(),
                house.isSecondaryIsThereHeatWaterCirculation(),
                house.isSecondaryIsThereHeatWaterBufferOrTank(),

                house.getVentilationType(),

                house.getCeilingOverTheFlatType(),
                house.getCeilingBelowTheFlatType(),
                house.getFloorNumberInTheBuilding(),

                house.getEntranceDoorType(),
                house.getWindowFrameMaterial(),
                house.getNumberOfGlasses(),

                house.getExternalMaterialWallsType(),
                house.getExternalMaterialWallsThicknessInCentimeters(),
                house.getExternalIsolationWallsType(),
                house.getExternalIsolationWallsThicknessInCentimeters(),
               houseWallDtoss,
                house.isAreThereAnyUnheatedRoomsInHouse(),
               unheatedRoomDtoss,
                house.isHouseBuildCorrectly(),
                house.getHouseNotBuildCorrectlyInformation(),
                house.isHasHouseAirConditioning(),
                house.getAirConditioningPowerInKw(),
                house.isHasInstalledRecuperator(),
                house.getRecuperatorModel(),

               dataDtoss,
                house.getAdditionalInformation(),
                house.getSendFormDate(),
                house.isCertificationIsCompleted()

        );
    }
}
