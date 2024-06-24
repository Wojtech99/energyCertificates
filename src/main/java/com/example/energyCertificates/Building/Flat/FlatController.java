package com.example.energyCertificates.Building.Flat;

import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.Flat.Dtoes.FlatDto;
import com.example.energyCertificates.Building.Flat.Dtoes.ThermalModernizationScopeClassDto;
import com.example.energyCertificates.Building.Flat.Enums.ExternalWallLayout;
import com.example.energyCertificates.Building.Flat.Enums.ThermalModernizationScope;
import com.example.energyCertificates.Building.Flat.service.FlatService;
import com.example.energyCertificates.Building.House.Enums.EntranceDoorType;
import com.example.energyCertificates.Building.House.Enums.RoomType;
import com.example.energyCertificates.Building.House.Enums.WorldParts;
import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.ClientService;
import com.example.energyCertificates.Data.DataDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
public class FlatController {
    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping("/flat/new-flat-form")
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


        model.addAttribute("flat", new FlatDto());

        return "new-flat-form";
    }

    @PostMapping("/flat/new-flat-form/save")
    String saveNewFlat(
            @RequestParam("floorNumberInTheBuildingInPolishString") String floorNumberInTheBuildingInPolishString,
            @RequestParam("ceilingBelowTheFlatTypeInPolishString") String ceilingBelowTheFlatTypeInPolishString,
            @RequestParam("ceilingOverTheFlatTypeInPolishString") String ceilingOverTheFlatTypeInPolishString,
            @RequestParam("externalMaterialWallsTypeInPolishString") String externalMaterialWallsTypeInPolishString,
            @RequestParam("externalIsolationWallsTypeInPolishString") String externalIsolationWallsTypeInPolishString,
            @RequestParam("externalWallLayoutInPolishString") String externalWallLayoutInPolishString,
            @RequestParam("windowFrameMaterialInPolishString") String windowFrameMaterialInPolishString,
            @RequestParam("numberOfGlassesInPolishString") String numberOfGlassesInPolishString,
            @RequestParam("heatingTypeInPolishString") String heatingTypeInPolishString,
            @RequestParam("radiatorsTypeInPolishString") String radiatorsTypeInPolishString,
            @RequestParam("heatingOfWaterTypeInPolishString") String heatingOfWaterTypeInPolishString,
            @RequestParam("ventilationTypeInPolishString") String ventilationTypeInPolishString,
            @RequestParam("thermalModernizationScope_1") String thermalModernizationScope_1,
            @RequestParam("thermalModernizationScope_2") String thermalModernizationScope_2,
            @RequestParam("thermalModernizationScope_3") String thermalModernizationScope_3,
            @ModelAttribute("flat") FlatDto flatDto,
            @RequestParam("attachmentList")List<MultipartFile> attachments) {

        flatDto.setFloorNumberInBuilding(FloorNumberInTheBuilding.mapToEnum(floorNumberInTheBuildingInPolishString));
        flatDto.setCeilingBelowTheFlatType(CeilingBelowTheFlatType.mapToEnum(ceilingBelowTheFlatTypeInPolishString));
        flatDto.setCeilingOverTheFlatType(CeilingOverTheFlatType.mapToEnum(ceilingOverTheFlatTypeInPolishString));
        flatDto.setExternalMaterialWallsType(ExternalMaterialWallsType.mapToEnum(externalMaterialWallsTypeInPolishString));
        flatDto.setExternalIsolationWallsType(ExternalIsolationWallsType.mapToEnum(externalIsolationWallsTypeInPolishString));
        flatDto.setExternalWallLayout(ExternalWallLayout.mapToEnum(externalWallLayoutInPolishString));
        flatDto.setWindowFrameMaterial(WindowFrameMaterial.mapToEnum(windowFrameMaterialInPolishString));
        flatDto.setNumberOfGlasses(NumberOfGlasses.mapToEnum(numberOfGlassesInPolishString));
        flatDto.setHeatingType(HeatingType.mapToEnum(heatingTypeInPolishString));
        flatDto.setRadiatorsType(RadiatorsType.mapToEnum(radiatorsTypeInPolishString));
        flatDto.setHeatingOfWaterType(HeatingOfWaterType.mapToEnum(heatingOfWaterTypeInPolishString));
        flatDto.setVentilationType(VentilationType.mapToEnum(ventilationTypeInPolishString));

        ThermalModernizationScopeClassDto thermalModernizationScopeClassDto_1 = new ThermalModernizationScopeClassDto(ThermalModernizationScope.mapToEnum(thermalModernizationScope_1));
        ThermalModernizationScopeClassDto thermalModernizationScopeClassDto_2 = new ThermalModernizationScopeClassDto(ThermalModernizationScope.mapToEnum(thermalModernizationScope_2));
        ThermalModernizationScopeClassDto thermalModernizationScopeClassDto_3 = new ThermalModernizationScopeClassDto(ThermalModernizationScope.mapToEnum(thermalModernizationScope_3));

        flatDto.getThermalModernizationScopeList().add(thermalModernizationScopeClassDto_1);
        flatDto.getThermalModernizationScopeList().add(thermalModernizationScopeClassDto_2);
        flatDto.getThermalModernizationScopeList().add(thermalModernizationScopeClassDto_3);

        flatService.save(flatDto, attachments);

        return "redirect:/";
    }
}
