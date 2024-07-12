package com.example.energyCertificates.Building;

import com.example.energyCertificates.Building.Enums.BuildingType;
import com.example.energyCertificates.Building.Flat.service.FlatService;
import com.example.energyCertificates.Building.House.Service.HouseService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.TreeSet;

@Controller
public class BuildingController {
    private final BuildingService buildingService;
    private final HouseService houseService;
    private final FlatService flatService;

    public BuildingController(BuildingService buildingService, HouseService houseService, FlatService flatService) {
        this.buildingService = buildingService;
        this.houseService = houseService;
        this.flatService = flatService;
    }

    @GetMapping("/energy-performance-certificates-list")
    String showUncompletedEnergyCertificates(Model model) {
        TreeSet<BuildingDto> buildingDtoTreeSet = buildingService.getAllBuildings();

        model.addAttribute("buildingList", buildingDtoTreeSet);

        return "energy-certificates-list";
    }

    @RequestMapping(
            value = "/delete-building/{city}/{street}/{houseNumber}/{flatNumber}/{postalCode}/{date}/{buildingType}",
            method = {RequestMethod.GET, RequestMethod.DELETE}
    )
    String deleteBuilding(@PathVariable String buildingType,
                          @PathVariable String city,
                          @PathVariable Date date,
                          @PathVariable int flatNumber,
                          @PathVariable int houseNumber,
                          @PathVariable String postalCode,
                          @PathVariable String street) {
        buildingService.deleteBuilding(new BuildingDto(
                date,
                city,
                street,
                houseNumber,
                flatNumber,
                postalCode,
                BuildingType.valueOf(buildingType)
        ));

        return "redirect:/energy-performance-certificates-list";
    }

    @GetMapping("/building/export-to-pdf/{city}/{street}/{houseNumber}/{flatNumber}/{postalCode}/{date}/{buildingType}")
    ResponseEntity<ByteArrayResource> downloadAgreement(
            @PathVariable String buildingType,
            @PathVariable String city,
            @PathVariable Date date,
            @PathVariable int flatNumber,
            @PathVariable int houseNumber,
            @PathVariable String postalCode,
            @PathVariable String street
    ) {
        BuildingDto buildingDto = new BuildingDto(
                date,
                city,
                street,
                houseNumber,
                flatNumber,
                postalCode,
                BuildingType.valueOf(buildingType)
        );

        String title = buildingService.changePolishLetters(
                buildingDto.getStreet() + "_" +
                buildingDto.getHouseNumber()  + "_" +
                buildingDto.getFlatNumber());

        byte[] zipBytes;
        if (buildingDto.getBuildingType().equals(BuildingType.HOUSE)) {
            zipBytes = houseService.getZipBytes(buildingDto, title);
        } else {
            zipBytes = flatService.getZipBytes(buildingDto, title);
        }

        ByteArrayResource resource = new ByteArrayResource(zipBytes);


        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + title + ".zip")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(zipBytes.length)
                .body(resource);
    }
}
