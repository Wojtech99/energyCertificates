package com.example.energyCertificates.Building;

import com.example.energyCertificates.Building.Enums.BuildingType;
import com.example.energyCertificates.Building.Flat.service.FlatService;
import com.example.energyCertificates.Building.House.Service.HouseService;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @GetMapping("/energy-performance-certificates-list/download")
    String downloadEnergyCertificate(@ModelAttribute BuildingDto buildingDto) {
        return "redirect:/energy-performance-certificates-list";
    }

    @GetMapping("/house/export-to-pdf/{city}/{street}/{houseNumber}/{flatNumber}/{postalCode}/{date}/{buildingType}")
    public void exportHouseToPdf(
            @PathVariable String buildingType,
            @PathVariable String city,
            @PathVariable Date date,
            @PathVariable int flatNumber,
            @PathVariable int houseNumber,
            @PathVariable String postalCode,
            @PathVariable String street,
            HttpServletResponse response
    ) throws IOException {
        BuildingDto buildingDto = new BuildingDto(
                date,
                city,
                street,
                houseNumber,
                flatNumber,
                postalCode,
                BuildingType.valueOf(buildingType)
        );


        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" +
                buildingDto.getStreet() + "_" +
                buildingDto.getHouseNumber()  + "_" +
                buildingDto.getFlatNumber() +
                ".pdf";

        response.setHeader(headerKey, headerValue);

        if (buildingDto.getBuildingType().equals(BuildingType.HOUSE)) {
            houseService.exportPdf(response, buildingDto);
        } else {
            flatService.exportPdf(response, buildingDto);
        }



    }
}
