package com.example.energyCertificates.Building;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.TreeSet;

@Controller
public class BuildingController {
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/energy-performance-certificates-list")
    String showUncompletedEnergyCertificates(Model model) {
        TreeSet<BuildingDto> buildingDtoTreeSet = buildingService.getAllBuildings();

        model.addAttribute("buildingList", buildingDtoTreeSet);

        return "energy-certificates-list";
    }

    @DeleteMapping("/delete-building")
    String deleteBuilding(@ModelAttribute BuildingDto buildingDto) {
        buildingService.deleteBuilding(buildingDto);

        return "redirect:/completed-energy-performance-certificates";
    }
}
