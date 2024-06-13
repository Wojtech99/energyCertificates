package com.example.energyCertificates.Building.House;

import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.Flat.Enums.ExternalWallLayout;
import com.example.energyCertificates.Building.Flat.Enums.ThermalModernizationScope;
import com.example.energyCertificates.Building.House.Dtoes.HouseDto;

import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.Dtoes.UnheatedRoomDto;
import com.example.energyCertificates.Building.House.Enums.EntranceDoorType;
import com.example.energyCertificates.Building.House.Enums.RoomType;
import com.example.energyCertificates.Building.House.Enums.WorldParts;
import com.example.energyCertificates.Building.House.Service.HouseService;
import com.example.energyCertificates.Data.DataDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/house/new-house-form")
    String addNewFlat(Model model) {
        List<String> listOfFloorNumberInTheBuilding = Arrays.stream(FloorNumberInTheBuilding.values()).map(FloorNumberInTheBuilding::getNameInPolish).toList();
        List<String> listOfCeilingOverTheFlatType = Arrays.stream(CeilingOverTheFlatType.values()).map(CeilingOverTheFlatType::getNameInPolish).toList();
        List<String> listOfCeilingBelowTheFlatType = Arrays.stream(CeilingBelowTheFlatType.values()).map(CeilingBelowTheFlatType::getNameInPolish).toList();
        List<String> listOfExternalMaterialWallsType = Arrays.stream(ExternalMaterialWallsType.values()).map(ExternalMaterialWallsType::getNameInPolish).toList();
        List<String> listOfExternalIsolationWallsType = Arrays.stream(ExternalIsolationWallsType.values()).map(ExternalIsolationWallsType::getNameInPolish).toList();
        List<String> listOfExternalWallLayout = Arrays.stream(ExternalWallLayout.values()).map(ExternalWallLayout::getNameInPolish).toList();
        List<String> listOfWindowFrameMaterial = Arrays.stream(WindowFrameMaterial.values()).map(WindowFrameMaterial::getNameInPolish).toList();
        List<String> listOfNumberOfGlasses = Arrays.stream(NumberOfGlasses.values()).map(NumberOfGlasses::getNameInPolish).toList();
        List<String> listOfHeatingType = Arrays.stream(HeatingType.values()).map(HeatingType::getNameInPolish).toList();
        List<String> listOfRadiatorsType = Arrays.stream(RadiatorsType.values()).map(RadiatorsType::getNameInPolish).toList();
        List<String> listOfHeatingOfWaterType = Arrays.stream(HeatingOfWaterType.values()).map(HeatingOfWaterType::getNameInPolish).toList();
        List<String> listOfVentilationType = Arrays.stream(VentilationType.values()).map(VentilationType::getNameInPolish).toList();

        List<String> listOfThermalModernizationScope = Arrays.stream(ThermalModernizationScope.values()).map(ThermalModernizationScope::getNameInPolish).toList();

        model.addAttribute("listOfFloorNumberInTheBuilding", listOfFloorNumberInTheBuilding);
        model.addAttribute("listOfCeilingOverTheFlatType", listOfCeilingOverTheFlatType);
        model.addAttribute("listOfCeilingBelowTheFlatType", listOfCeilingBelowTheFlatType);
        model.addAttribute("listOfExternalMaterialWallsType", listOfExternalMaterialWallsType);
        model.addAttribute("listOfExternalIsolationWallsType", listOfExternalIsolationWallsType);
        model.addAttribute("listOfExternalWallLayout", listOfExternalWallLayout);
        model.addAttribute("listOfWindowFrameMaterial", listOfWindowFrameMaterial);
        model.addAttribute("listOfNumberOfGlasses", listOfNumberOfGlasses);
        model.addAttribute("listOfHeatingType", listOfHeatingType);
        model.addAttribute("listOfRadiatorsType", listOfRadiatorsType);
        model.addAttribute("listOfHeatingOfWaterType", listOfHeatingOfWaterType);
        model.addAttribute("listOfVentilationType", listOfVentilationType);

        model.addAttribute("listOfThermalModernizationScope", listOfThermalModernizationScope);


        model.addAttribute("house", new HouseDto());

        return "new-house-form";
    }

    @PostMapping("/house/new-house-form/save")
    String saveNewHouse(
            @RequestParam("heatingTypeInPolishString") String heatingType,
            @RequestParam("radiatorsTypeInPolishString") String radiatorsType,
            @RequestParam("secondaryHeatingTypeInPolishString") String secondaryHeatingType,
            @RequestParam("secondaryRadiatorsTypeInPolishString") String secondaryRadiatorsType,
            @RequestParam("heatingOfWaterTypeInPolishString") String heatingOfWaterType,
            @RequestParam("secondaryHeatingOfWaterTypeInPolishString") String secondaryHeatingOfWaterType,
            @RequestParam("ventilationTypeInPolishString") String ventilationType,
            @RequestParam("ceilingOverTheFlatTypeInPolishString") String ceilingOverTheFlatType,
            @RequestParam("ceilingBelowTheFlatTypeInPolishString") String ceilingBelowTheFlatType,
            @RequestParam("floorNumberInTheBuildingInPolishString") String floorNumberInTheBuilding,
            @RequestParam("entranceDoorTypeInPolishString") String entranceDoorType,
            @RequestParam("windowFrameMaterialInPolishString") String windowFrameMaterial,
            @RequestParam("numberOfGlassesInPolishString") String numberOfGlasses,
            @RequestParam("externalMaterialWallsTypeInPolishString") String externalMaterialWallsType,
            @RequestParam("externalIsolationWallsTypeInPolishString") String externalIsolationWallsType,
            @RequestParam("worldPart_1_name") String wp1n,
            @RequestParam("worldPart_2_name") String wp2n,
            @RequestParam("worldPart_3_name") String wp3n,
            @RequestParam("worldPart_4_name") String wp4n,
            @RequestParam("worldPart_5_name") String wp5n,
            @RequestParam("worldPart_6_name") String wp6n,
            @RequestParam("worldPart_7_name") String wp7n,
            @RequestParam("worldPart_8_name") String wp8n,
            @RequestParam("worldPart_1_m") Double wp1m,
            @RequestParam("worldPart_2_m") Double wp2m,
            @RequestParam("worldPart_3_m") Double wp3m,
            @RequestParam("worldPart_4_m") Double wp4m,
            @RequestParam("worldPart_5_m") Double wp5m,
            @RequestParam("worldPart_6_m") Double wp6m,
            @RequestParam("worldPart_7_m") Double wp7m,
            @RequestParam("worldPart_8_m") Double wp8m,
            @RequestParam("unheatedRoom_1_name") String ur1n,
            @RequestParam("unheatedRoom_2_name") String ur2n,
            @RequestParam("unheatedRoom_3_name") String ur3n,
            @RequestParam("unheatedRoom_1_m") Integer ur1m,
            @RequestParam("unheatedRoom_2_m") Integer ur2m,
            @RequestParam("unheatedRoom_3_m") Integer ur3m,
            @ModelAttribute("house") HouseDto houseDto,
            @RequestParam("attachments")List<MultipartFile> attachments) {


        houseDto.setHeatingType(HeatingType.mapToEnum(heatingType));
        houseDto.setRadiatorsType(RadiatorsType.mapToEnum(radiatorsType));
        houseDto.setSecondaryHeatingType(HeatingType.mapToEnum(secondaryHeatingType));
        houseDto.setSecondaryRadiatorsType(RadiatorsType.mapToEnum(secondaryRadiatorsType));
        houseDto.setHeatingOfWaterType(HeatingOfWaterType.mapToEnum(heatingOfWaterType));
        houseDto.setSecondaryHeatingOfWaterType(HeatingOfWaterType.mapToEnum(secondaryHeatingOfWaterType));
        houseDto.setVentilationType(VentilationType.mapToEnum(ventilationType));
        houseDto.setCeilingOverTheFlatType(CeilingOverTheFlatType.mapToEnum(ceilingOverTheFlatType));
        houseDto.setCeilingBelowTheFlatType(CeilingBelowTheFlatType.mapToEnum(ceilingBelowTheFlatType));
        houseDto.setFloorNumberInTheBuilding(FloorNumberInTheBuilding.mapToEnum(floorNumberInTheBuilding));
        houseDto.setEntranceDoorType(EntranceDoorType.mapToEnum(entranceDoorType));
        houseDto.setWindowFrameMaterial(WindowFrameMaterial.mapToEnum(windowFrameMaterial));
        houseDto.setNumberOfGlasses(NumberOfGlasses.mapToEnum(numberOfGlasses));
        houseDto.setExternalMaterialWallsType(ExternalMaterialWallsType.mapToEnum(externalMaterialWallsType));
        houseDto.setExternalIsolationWallsType(ExternalIsolationWallsType.mapToEnum(externalIsolationWallsType));


        HouseWallDto houseWallDto_1 = new HouseWallDto(WorldParts.mapToEnum(wp1n),wp1m);
        HouseWallDto houseWallDto_2 = new HouseWallDto(WorldParts.mapToEnum(wp2n),wp2m);
        HouseWallDto houseWallDto_3 = new HouseWallDto(WorldParts.mapToEnum(wp3n),wp3m);
        HouseWallDto houseWallDto_4 = new HouseWallDto(WorldParts.mapToEnum(wp4n),wp4m);
        HouseWallDto houseWallDto_5 = new HouseWallDto(WorldParts.mapToEnum(wp5n),wp5m);
        HouseWallDto houseWallDto_6 = new HouseWallDto(WorldParts.mapToEnum(wp6n),wp6m);
        HouseWallDto houseWallDto_7 = new HouseWallDto(WorldParts.mapToEnum(wp7n),wp7m);
        HouseWallDto houseWallDto_8 = new HouseWallDto(WorldParts.mapToEnum(wp8n),wp8m);

        houseDto.getHauseWallDtoList().add(houseWallDto_1);
        houseDto.getHauseWallDtoList().add(houseWallDto_2);
        houseDto.getHauseWallDtoList().add(houseWallDto_3);
        houseDto.getHauseWallDtoList().add(houseWallDto_4);
        houseDto.getHauseWallDtoList().add(houseWallDto_5);
        houseDto.getHauseWallDtoList().add(houseWallDto_6);
        houseDto.getHauseWallDtoList().add(houseWallDto_7);
        houseDto.getHauseWallDtoList().add(houseWallDto_8);

        UnheatedRoomDto unheatedRoomDto_1 = new UnheatedRoomDto(RoomType.mapToEnum(ur1n), ur1m);
        UnheatedRoomDto unheatedRoomDto_2 = new UnheatedRoomDto(RoomType.mapToEnum(ur2n), ur2m);
        UnheatedRoomDto unheatedRoomDto_3 = new UnheatedRoomDto(RoomType.mapToEnum(ur3n), ur3m);

        houseDto.getUnheatedRoomDtoList().add(unheatedRoomDto_1);
        houseDto.getUnheatedRoomDtoList().add(unheatedRoomDto_2);
        houseDto.getUnheatedRoomDtoList().add(unheatedRoomDto_3);

        attachments.forEach(attachment ->
                houseDto.getAttachmentDtoList().add(
                        new DataDto(attachment.getName())));



        houseService.saveHouse(houseDto);

        return "redirect:/";
    }
}
