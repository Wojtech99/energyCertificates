package com.example.energyCertificates.Building.Flat.service;

import com.example.energyCertificates.Building.BuildingDto;
import com.example.energyCertificates.Building.Flat.Dtoes.FlatDto;
import com.example.energyCertificates.Building.Flat.Dtoes.ThermalModernizationScopeClassDto;
import com.example.energyCertificates.Building.Flat.Enums.ThermalModernizationScope;
import com.example.energyCertificates.Building.Flat.Flat;
import com.example.energyCertificates.Building.Flat.Mappers.FlatMapper;
import com.example.energyCertificates.Building.Flat.Repos.FlatRepository;
import com.example.energyCertificates.Client.ClientService;
import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Data.DataDto;
import com.example.energyCertificates.Data.DataService;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FlatService {
    private final FlatRepository flatRepository;
    private final ClientService clientService;
    private final ThermalModernizationScopeService thermalService;
    private final DataService dataService;

    public FlatService(FlatRepository flatRepository, ClientService clientService, ThermalModernizationScopeService thermalService, DataService dataService) {
        this.flatRepository = flatRepository;
        this.clientService = clientService;
        this.thermalService = thermalService;
        this.dataService = dataService;
    }

    @Transactional
    public FlatDto save(FlatDto flatDto, List<MultipartFile> attachments) {
        Date date = new Date(System.currentTimeMillis());
        flatDto.setSendFormDate(date);

        List<ThermalModernizationScopeClassDto> thermalList = new ArrayList<>();

        ClientDto clientDtoToSave = flatDto.getClientDto();
        ClientDto savedClient = clientService.saveClient(clientDtoToSave);
        flatDto.setClientDto(savedClient);

        for (int i = 0; i < flatDto.getThermalModernizationScopeList().size(); i++) {
            ThermalModernizationScopeClassDto thermalClass = flatDto.getThermalModernizationScopeList().get(i);

            if (thermalClass.getEnumNumber().equals(ThermalModernizationScope.NULL)) {
                continue;
            }

            ThermalModernizationScopeClassDto savedThermalClass = thermalService.save(thermalClass);

            thermalList.add(savedThermalClass);
        }


        if (!attachments.isEmpty()) {
            attachments.forEach(attachment -> {
                try {
                    DataDto dataDto = new DataDto(
                            attachment.getOriginalFilename(),
                            attachment.getContentType(),
                            attachment.getBytes()
                    );

                    DataDto savedAttachment = dataService.save(dataDto);
                    flatDto.getAttachments().add(savedAttachment);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        flatDto.setThermalModernizationScopeList(thermalList);

        Flat flatToSave = FlatMapper.map(flatDto);
        Flat savedFlat = flatRepository.save(flatToSave);

        return FlatMapper.map(savedFlat);
    }

    private FlatDto findFlatFromBuilding(BuildingDto buildingDto) {
        Flat flatToDelete = flatRepository.getByCityAndStreetAndPostalCodeAndSendFormDate(
                buildingDto.getCity(),
                buildingDto.getStreet(),
                buildingDto.getPostalCode(),
                buildingDto.getDate()
        );

        return FlatMapper.map(flatToDelete);
    }

    @Transactional
    public void delete(BuildingDto buildingDto) {
        FlatDto flatDto = findFlatFromBuilding(buildingDto);

        List<ThermalModernizationScopeClassDto> thermalDtoList= flatDto.getThermalModernizationScopeList();
        List<DataDto> dataDtoList = flatDto.getAttachments();

        thermalDtoList.forEach(thermalService::delete);
        dataDtoList.forEach(dataService::delete);

        Flat flatToDelete = FlatMapper.map(flatDto);
        flatRepository.deleteById(flatToDelete.getId());
    }

    public List<FlatDto> getFlatWithCondition(Predicate<FlatDto> filteringCondition) {
        List<FlatDto> flatDtoList = flatRepository.getAll().stream()
                .map(FlatMapper::map)
                .toList();
        List<FlatDto> filteredFlatDtoList = new ArrayList<>();

        for (FlatDto flatDto : flatDtoList) {
            if (filteringCondition.test(flatDto)) {
                filteredFlatDtoList.add(flatDto);
            }
        }

        return filteredFlatDtoList;
    }

    private byte[] getPdfInBytes(BuildingDto buildingDto) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        FlatDto flatDto = findFlatFromBuilding(buildingDto);
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);


        document.open();

        document.setDocumentLanguage("pl-PL");
        document.addAuthor("Autor");
        document.addSubject("Przykład PDF w języku polskim");
        document.addKeywords("PDF, polski");
        document.addCreator("OpenPDF w Spring Boot");

        Font titleFont = new Font(Font.BOLD, 26, Font.TIMES_ROMAN, Color.BLACK);
        Font headingFont = new Font(Font.BOLD, 16, Font.TIMES_ROMAN, Color.BLACK);
        Font normalTextFont = new Font(Font.NORMAL, 12, Font.TIMES_ROMAN, Color.BLACK);

        // Set the language to Polish using setViewerPreferences
        writer.setViewerPreferences(PdfWriter.DisplayDocTitle);
        writer.getExtraCatalog().put(PdfName.LANG, new com.lowagie.text.pdf.PdfString("pl-PL"));

//title
        Paragraph titleParagraph = new Paragraph(
                flatDto.getStreet() + " " +
                        flatDto.getHouseNumber() + "/" + flatDto.getFlatNumber() + ", " +
                        flatDto.getCity() + " " + flatDto.getPostalCode(),
                titleFont);
        titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);


//client data
        Paragraph headingClientDataParagraph = new Paragraph(
                "Dane Klienta",
                headingFont
        );
        headingClientDataParagraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalClientDataParagraph = new Paragraph(
                "Imie i Nazwisko: " + flatDto.getClientDto().getFirstName() + " " +
                        flatDto.getClientDto().getLastName() + "\n" +
                        "Email: " + flatDto.getClientDto().getEmail() + "\n" +
                        "Numer telefonu: " + flatDto.getClientDto().getPhoneNumber() + "\n" +
                        "Nazwa firmy: " + flatDto.getClientDto().getCompanyName() + "\n" +
                        "Nip firmy: " + flatDto.getClientDto().getCompanyNumber() + "\n" +
                        "Adres firmy: " + flatDto.getClientDto().getCompanyAddress(),
                normalTextFont
        );
        normalClientDataParagraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Basic data of the flat
        Paragraph headingBasicDataOfTheFlat = new Paragraph(
                "\nPodstawowe dane domu",
                headingFont
        );
        headingBasicDataOfTheFlat.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalBasicDataOfTheFlat = new Paragraph(
                "Ulica: " + flatDto.getStreet() + "\n" +
                        "Numer domu: " + flatDto.getHouseNumber() + "\n" +
                        "Numer mieszkania: " + flatDto.getFlatNumber() + "\n" +
                        "Kod pocztowy: " + flatDto.getPostalCode() + "\n" +
                        "Miasto: " + flatDto.getCity() + "\n" +
                        "Powierzchnia użytkowa: " + flatDto.getUsableArea() + "\n" +
                        "Wysokość mieszkania: " + flatDto.getHeightOfFlat() + "\n" +
                        "Rok oddania budynku: " + flatDto.getYearOfCommissioningOfTheBuilding() + "\n" +
                        "Rodzaj Mieszkania: " + flatDto.getFloorNumberInBuilding().getNameInPolish() + "\n" +
                        "Czy budynek jest po termomodernizacji: " + flatDto.isTheBuildingIsAfterThermalModernization() + "\n" +
                        "Rok ostatniej termomodernizacji budynku: " + flatDto.getLastBuildingThermalModernizationYear() + "\n" +
                        "Zakres termomodernizacji: " + getAllThermalModernizationScopesAsString(flatDto.getThermalModernizationScopeList()) + "\n" +
                        "Czy mieszkanie jest na parterze: " + flatDto.isFlatIsAtGroundFloor() + "\n" +
                        "Typ stropu pod mieszkaniem: " + flatDto.getCeilingBelowTheFlatType().getNameInPolish() + "\n" +
                        "Czy mieszkanie jest na ostatnim piętrze: " + flatDto.isFlatIsAtLastFloor() + "\n" +
                        "Typ stropu nad mieszkaniem: " + flatDto.getCeilingOverTheFlatType().getNameInPolish(),
                normalTextFont
        );
        normalBasicDataOfTheFlat.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Walls
        Paragraph headingWalls = new Paragraph(
                "\nŚciany",
                headingFont
        );
        headingWalls.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalWalls = new Paragraph(
                "Typ materiału ścian zewnętrznych: " + flatDto.getExternalMaterialWallsType().getNameInPolish() + "\n" +
                        "Grubość materiału ścian zewnętrznych w centymetrach: " + flatDto.getExternalMaterialWallsThicknessInCentimeters() + "\n" +
                        "Typ izolacji ścian zewnętrznych: " + flatDto.getExternalIsolationWallsType().getNameInPolish() + "\n" +
                        "Grubość izolacji ścian zewnętrznych w centymetrach: " + flatDto.getExternalIsolationWallsThicknessInCm() + "\n" +
                        "Układ ścian zewnętrznych: " + flatDto.getExternalWallLayout().getNameInPolish(),
                normalTextFont
        );
        normalWalls.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Windows
        Paragraph headingWindows = new Paragraph(
                "\nOkna",
                headingFont
        );
        headingWindows.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalWindows = new Paragraph(
                "Materiał ram okien: " + flatDto.getWindowFrameMaterial().getNameInPolish() + "\n" +
                        "Liczba szyb w oknach: " + flatDto.getNumberOfGlasses().getNameInPolish(),
                  normalTextFont
        );
        normalWindows.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Heating and Ventilation
        Paragraph headingHeatingAndVentilation = new Paragraph(
                "\nOgrzewanie i wentylacja",
                headingFont
        );
        headingHeatingAndVentilation.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalHeatingAndVentilation = new Paragraph(
                "Typ ogrzewania: " + flatDto.getHeatingType().getNameInPolish() + "\n" +
                        "Typ grzejników: " + flatDto.getRadiatorsType().getNameInPolish() + "\n" +
                        "Typ ogrzewania wody: " + flatDto.getHeatingOfWaterType().getNameInPolish() + "\n" +
                        "Typ wentylacji: " + flatDto.getVentilationType().getNameInPolish(),
                normalTextFont
        );
        normalHeatingAndVentilation.setAlignment(Paragraph.ALIGN_JUSTIFIED);

//Additional information
        Paragraph headingAdditionalInformation = new Paragraph(
                "\nDodatkowe informacje",
                headingFont
        );
        headingAdditionalInformation.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalAdditionalInformation = new Paragraph(
                "Dodatkowe informacje:\n" + "\t\t" + flatDto.getAdditionalInformation(),
                normalTextFont
        );
        normalAdditionalInformation.setAlignment(Paragraph.ALIGN_JUSTIFIED);


        document.add(titleParagraph);

        document.add(headingClientDataParagraph);
        document.add(normalClientDataParagraph);

        document.add(headingBasicDataOfTheFlat);
        document.add(normalBasicDataOfTheFlat);

        document.add(headingWalls);
        document.add(normalWalls);

        document.add(headingWindows);
        document.add(normalWindows);

        document.add(headingHeatingAndVentilation);
        document.add(normalHeatingAndVentilation);

        document.add(headingAdditionalInformation);
        document.add(normalAdditionalInformation);

        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    private String getAllThermalModernizationScopesAsString(List<ThermalModernizationScopeClassDto> thermalScopeList) {
        StringBuffer allThermals = new StringBuffer();
        allThermals.append("\n");

        for (ThermalModernizationScopeClassDto thermal : thermalScopeList) {
            allThermals.append("\t\t -")
                    .append(thermal.getEnumNumber().getNameInPolish())
                    .append(",\n");
        }

        return allThermals.toString();
    }

    public byte[] getZipBytes(BuildingDto buildingDto, String title) {
        byte[] pdfBytes = getPdfInBytes(buildingDto);

        List<byte[]> images = new ArrayList<>();
        FlatDto flatDto = findFlatFromBuilding(buildingDto);
        flatDto.getAttachments().forEach(attachment -> images.add(attachment.getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            ZipEntry PdfZipEntry = new ZipEntry(title + ".pdf");
            zipOutputStream.putNextEntry(PdfZipEntry);
            zipOutputStream.write(pdfBytes);
            zipOutputStream.closeEntry();

            for (int i = 0; i < images.size(); i++) {
                byte[] image = images.get(i);

                ZipEntry zipEntryImage = new ZipEntry(title + "_" + (i + 1) + ".png");
                zipOutputStream.putNextEntry(zipEntryImage);
                zipOutputStream.write(image);
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while creating ZIP file", e);
        }

        return byteArrayOutputStream.toByteArray();
    }
}
