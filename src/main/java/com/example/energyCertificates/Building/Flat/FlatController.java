package com.example.energyCertificates.Building.Flat;

import com.example.energyCertificates.Building.Enums.*;
import com.example.energyCertificates.Building.Flat.Dtoes.FlatDto;
import com.example.energyCertificates.Building.Flat.service.FlatService;
import com.example.energyCertificates.Building.House.Enums.EntranceDoorType;
import com.example.energyCertificates.Building.House.Enums.RoomType;
import com.example.energyCertificates.Building.House.Enums.WorldParts;
import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<String> listOfHeatingType = Arrays.stream(HeatingType.values()).map(HeatingType::getNameInPolish).toList();
        List<String> listOfRadiatorsType = Arrays.stream(RadiatorsType.values()).map(RadiatorsType::getNameInPolish).toList();
        List<String> listOfHeatingOfWaterType = Arrays.stream(HeatingOfWaterType.values()).map(HeatingOfWaterType::getNameInPolish).toList();
        List<String> listOfVentilationType = Arrays.stream(VentilationType.values()).map(VentilationType::getNameInPolish).toList();
        List<String> listOfCeilingOverTheFlatType = Arrays.stream(CeilingOverTheFlatType.values()).map(CeilingOverTheFlatType::getNameInPolish).toList();
        List<String> listOfCeilingBelowTheFlatType = Arrays.stream(CeilingBelowTheFlatType.values()).map(CeilingBelowTheFlatType::getNameInPolish).toList();
        List<String> listOfFloorNumberInTheBuilding = Arrays.stream(FloorNumberInTheBuilding.values()).map(FloorNumberInTheBuilding::getNameInPolish).toList();
        List<String> listOfEntranceDoorType = Arrays.stream(EntranceDoorType.values()).map(EntranceDoorType::getNameInPolish).toList();
        List<String> listOfWindowFrameMaterial = Arrays.stream(WindowFrameMaterial.values()).map(WindowFrameMaterial::getNameInPolish).toList();
        List<String> listOfNumberOfGlasses = Arrays.stream(NumberOfGlasses.values()).map(NumberOfGlasses::getNameInPolish).toList();
        List<String> listOfExternalMaterialWallsType = Arrays.stream(ExternalMaterialWallsType.values()).map(ExternalMaterialWallsType::getNameInPolish).toList();
        List<String> listOfExternalIsolationWallsType = Arrays.stream(ExternalIsolationWallsType.values()).map(ExternalIsolationWallsType::getNameInPolish).toList();

        List<String> listOfWorldParts = Arrays.stream(WorldParts.values()).map(WorldParts::getNameInPolish).toList();
        List<String> listOfRoomType = Arrays.stream(RoomType.values()).map(RoomType::getNameInPolish).toList();

        model.addAttribute("listOfHeatingType", listOfHeatingType);
        model.addAttribute("listOfRadiatorsType", listOfRadiatorsType);
        model.addAttribute("listOfHeatingOfWaterType", listOfHeatingOfWaterType);
        model.addAttribute("listOfVentilationType", listOfVentilationType);
        model.addAttribute("listOfCeilingOverTheFlatType", listOfCeilingOverTheFlatType);
        model.addAttribute("listOfCeilingBelowTheFlatType", listOfCeilingBelowTheFlatType);
        model.addAttribute("listOfFloorNumberInTheBuilding", listOfFloorNumberInTheBuilding);
        model.addAttribute("listOfEntranceDoorType", listOfEntranceDoorType);
        model.addAttribute("listOfWindowFrameMaterial", listOfWindowFrameMaterial);
        model.addAttribute("listOfNumberOfGlasses", listOfNumberOfGlasses);
        model.addAttribute("listOfExternalMaterialWallsType", listOfExternalMaterialWallsType);
        model.addAttribute("listOfExternalIsolationWallsType", listOfExternalIsolationWallsType);

        model.addAttribute("listOfRoomType", listOfRoomType);
        model.addAttribute("listOfWorldParts", listOfWorldParts);




        model.addAttribute("flat", new FlatDto());

        return "new-flat-form";
    }

    @PostMapping("/flat/new-flat-form/save")
    String saveNewFlat(@ModelAttribute("flat") FlatDto flatDto,
                       @ModelAttribute("client") ClientDto clientDto) {
        flatService.save(flatDto);

        return "redirect:/";
    }
}
