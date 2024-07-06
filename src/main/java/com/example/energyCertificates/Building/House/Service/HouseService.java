package com.example.energyCertificates.Building.House.Service;

import com.example.energyCertificates.Building.BuildingDto;
import com.example.energyCertificates.Building.House.Dtoes.HouseDto;
import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.Dtoes.UnheatedRoomDto;
import com.example.energyCertificates.Building.House.Enums.RoomType;
import com.example.energyCertificates.Building.House.Enums.WorldParts;
import com.example.energyCertificates.Building.House.House;
import com.example.energyCertificates.Building.House.Mappers.HouseMapper;
import com.example.energyCertificates.Building.House.Repos.HouseRepository;
import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.ClientService;

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
public class HouseService {
    private final HouseRepository houseRepository;
    private final ClientService clientService;
    private final HouseWallService houseWallService;
    private final UnheatedRoomService unheatedRoomService;
    private final DataService dataService;


    public HouseService(HouseRepository houseRepository, ClientService clientService, HouseWallService houseWallService, UnheatedRoomService unheatedRoomService, DataService dataService) {
        this.houseRepository = houseRepository;
        this.clientService = clientService;
        this.houseWallService = houseWallService;
        this.unheatedRoomService = unheatedRoomService;
        this.dataService = dataService;

    }

    @Transactional
    public HouseDto saveHouse(HouseDto houseDto, List<MultipartFile> attachments) {
        Date date = new Date(System.currentTimeMillis());
        houseDto.setSendFormDate(date);

        List<HouseWallDto> houseWallDtoList = new ArrayList<>();
        List<UnheatedRoomDto> unheatedRoomDtoList = new ArrayList<>();

        ClientDto clientDtoToSave = houseDto.getClientDto();
        ClientDto savedClient = clientService.saveClient(clientDtoToSave);
        houseDto.setClientDto(savedClient);


        for (int i = 0; i < houseDto.getHauseWallDtoList().size(); i++) {
            HouseWallDto houseWallDto = houseDto.getHauseWallDtoList().get(i);

            if (houseWallDto.getWorldPart().equals(WorldParts.NULL)) {
                continue;
            }

            HouseWallDto savedHouseWallDto = houseWallService.save(houseWallDto);

            houseWallDtoList.add(savedHouseWallDto);
        }

        for (int i = 0; i < houseDto.getUnheatedRoomDtoList().size(); i++) {
            UnheatedRoomDto unheatedRoomDto = houseDto.getUnheatedRoomDtoList().get(i);

            if (unheatedRoomDto.getRoomType().equals(RoomType.NULL)) {
                continue;
            }

            UnheatedRoomDto savedUnheatedRoomDto = unheatedRoomService.save(unheatedRoomDto);

            unheatedRoomDtoList.add(savedUnheatedRoomDto);
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
                    houseDto.getAttachmentDtoList().add(savedAttachment);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        houseDto.setHauseWallDtoList(houseWallDtoList);
        houseDto.setUnheatedRoomDtoList(unheatedRoomDtoList);


        House houseToSave = HouseMapper.map(houseDto);
        House savedHouse = houseRepository.save(houseToSave);

        return HouseMapper.map(savedHouse);
    }

    private HouseDto findHouseFromBuilding(BuildingDto buildingDto) {
        House houseToDelete = houseRepository.getByCityAndStreetAndPostalCodeAndSendFormDate(
                buildingDto.getCity(),
                buildingDto.getStreet(),
                buildingDto.getPostalCode(),
                buildingDto.getDate()
        );

        return HouseMapper.map(houseToDelete);
    }

    @Transactional
    public void delete(BuildingDto buildingDto) {
        HouseDto houseDto = findHouseFromBuilding(buildingDto);

        houseDto.getHauseWallDtoList().forEach(houseWallService::delete);
        houseDto.getUnheatedRoomDtoList().forEach(unheatedRoomService::delete);
        houseDto.getAttachmentDtoList().forEach(dataService::delete);

        House houseToDelete = HouseMapper.map(houseDto);
        houseRepository.deleteById(houseToDelete.getId());
    }

    public List<HouseDto> getAllHousesWithCondition(Predicate<HouseDto> predicate) {
        List<House> houseList = houseRepository.getAll();
        List<HouseDto> houseDtoList = houseList.stream().map(HouseMapper::map).toList();
        List<HouseDto> filteredHouseDtoList = new ArrayList<>();

        for (HouseDto houseDto : houseDtoList) {
            if (predicate.test(houseDto)) {
                filteredHouseDtoList.add(houseDto);
            }
        }

        return filteredHouseDtoList;
    }

    private byte[] getPdfInBytes(BuildingDto buildingDto) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        HouseDto houseDto = findHouseFromBuilding(buildingDto);
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
                houseDto.getStreet() + " " +
                        houseDto.getHouseNumber() + "/" + houseDto.getFlatNumber() + ", " +
                        houseDto.getCity() + " " + houseDto.getPostalCode(),
                titleFont);
        titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);


//client data
        Paragraph headingClientDataParagraph = new Paragraph(
                "Dane Klienta",
                headingFont
        );
        headingClientDataParagraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalClientDataParagraph = new Paragraph(
                "Imie i Nazwisko: " + houseDto.getClientDto().getFirstName() + " " +
                houseDto.getClientDto().getLastName() + "\n" +
                "Email: " + houseDto.getClientDto().getEmail() + "\n" +
                "Numer telefonu: " + houseDto.getClientDto().getPhoneNumber() + "\n" +
                "Nazwa firmy: " + houseDto.getClientDto().getCompanyName() + "\n" +
                "Nip firmy: " + houseDto.getClientDto().getCompanyNumber() + "\n" +
                "Adres firmy: " + houseDto.getClientDto().getCompanyAddress(),
                normalTextFont
        );
        normalClientDataParagraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Basic data of the house
        Paragraph headingBasicDataOfTheHouse = new Paragraph(
                "\nPodstawowe dane domu",
                headingFont
        );
        headingBasicDataOfTheHouse.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalBasicDataOfTheHouse = new Paragraph(
                "Ulica: " + houseDto.getStreet() + "\n" +
                        "Numer domu: " + houseDto.getHouseNumber() + "\n" +
                        "Numer mieszkania: " + houseDto.getFlatNumber() + "\n" +
                        "Kod pocztowy: " + houseDto.getPostalCode() + "\n" +
                        "Miasto: " + houseDto.getCity() + "\n" +
                        "Powierzchnia użytkowa: " + houseDto.getUsableArea() + "m2" + "\n" +
                        "Kubatura domu: " + houseDto.getVolumeOfHouse() + "m3" + "\n" +
                        "Rok oddania budynku: " + houseDto.getYearOfCommissioningOfTheBuilding(),
                normalTextFont
        );
        normalBasicDataOfTheHouse.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Heating
        Paragraph headingHeating = new Paragraph(
                "\nOgrzewanie",
                headingFont
        );
        headingHeating.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalHeating = new Paragraph(
                "Typ ogrzewania: " + houseDto.getHeatingType().getNameInPolish() + "\n" +
                        "Typ ogrzewania z modelem pieca: " + houseDto.getTypeOfHeatingWithFurnaceModel() + "\n" +
                        "Typ grzejników: " + houseDto.getRadiatorsType().getNameInPolish() + "\n" +
                        "Czy przewody instalacyjne sa izolowane: " + houseDto.isAreInstallationCablesInsulted() + "\n" +
                        "Czy jest cyrkulacja ogrzewania: " + houseDto.isThereHeatingCirculation() + "\n" +
                        "Czy jest bufor lub zbiornik ogrzewania: " + houseDto.isThereHeatingBufferOrTank() + "\n" +
                        "Czy jest dodatkowy typ ogrzewania: " + houseDto.isThereSecondaryHeatingType() + "\n" +
                        "     -Dodatkowy typ ogrzewania: " + houseDto.getSecondaryHeatingType().getNameInPolish() + "\n" +
                        "     -Dodatkowy typ ogrzewania z modelem pieca: " + houseDto.getSecondaryTypeOfHeatingWithFurnaceModel() + "\n" +
                        "     -Dodatkowy typ grzejników: " + houseDto.getSecondaryRadiatorsType().getNameInPolish() + "\n" +
                        "     -Czy dodatkowe przewody instalacyjne sa izolowane: " + houseDto.isSecondaryAreInstallationCablesInsulted() + "\n" +
                        "     -Czy jest dodatkowa cyrkulacja ogrzewania: " + houseDto.isSecondaryIsThereHeatingCirculation() + "\n" +
                        "     -Czy jest dodatkowy bufor lub zbiornik ogrzewania: " + houseDto.isSecondaryIsThereHeatingBufferOrTank() + "\n" +
                        "     -Procent wykorzystania dodatkowego typu ogrzewania: " + houseDto.getPercentOfUsageSecondaryHeatingType(),
                normalTextFont
        );
        normalHeating.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Hot water
        Paragraph headingHotWater = new Paragraph(
                "\nCiepła woda użytkowa",
                headingFont
        );
        headingHotWater.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalHotWater = new Paragraph(
                "Typ ogrzewania wody: " + houseDto.getHeatingOfWaterType().getNameInPolish() + "\n" +
                        "Typ ogrzewania wody z modelem pieca: " + houseDto.getTypeOfHeatingWaterWithFurnaceModel() + "\n" +
                        "Czy przewody instalacji wodnej sa izolowane: " + houseDto.isAreWaterInstallationCablesInsulted() + "\n" +
                        "Czy jest cyrkulacja wody grzewczej: " + houseDto.isThereHeatWaterCirculation() + "\n" +
                        "Czy jest bufor lub zbiornik wody grzewczej: " + houseDto.isThereHeatWaterBufferOrTank() + "\n" +
                        "Czy jest dodatkowy typ ogrzewania wody: " + houseDto.isThereSecondaryHeatingOfWaterType() + "\n" +
                        "     -Dodatkowy typ ogrzewania wody: " + houseDto.getSecondaryHeatingOfWaterType().getNameInPolish() + "\n" +
                        "     -Dodatkowy typ ogrzewania wody z modelem pieca: " + houseDto.getSecondaryTypeOfHeatingWaterWithFurnaceModel() + "\n" +
                        "     -Czy dodatkowe przewody instalacji wodnej sa izolowane: " + houseDto.isSecondaryAreWaterInstallationCablesInsulted() + "\n" +
                        "     -Czy jest dodatkowa cyrkulacja wody grzewczej: " + houseDto.isSecondaryIsThereHeatWaterCirculation() + "\n" +
                        "     -Czy jest dodatkowy bufor lub zbiornik wody grzewczej: " + houseDto.isSecondaryIsThereHeatWaterBufferOrTank() + "\n" +
                        "     -Procent wykorzystania dodatkowego typu ogrzewania wody: " + houseDto.getPercentOfUsageSecondaryHeatOfWaterType(),
                normalTextFont
        );
        normalHotWater.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Ventilation
        Paragraph headingVentilation = new Paragraph(
                "\nWentylacja",
                headingFont
        );
        headingVentilation.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalVentilation = new Paragraph(
                "Rodzaj wentylacji: " + houseDto.getVentilationType().getNameInPolish(),
                normalTextFont

        );
        normalVentilation.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Ceiling
        Paragraph headingCeiling = new Paragraph(
                "\nStropy",
                headingFont
        );
        headingCeiling.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalCeiling = new Paragraph(
                "Typ dachu: " + houseDto.getCeilingOverTheFlatType().getNameInPolish() + "\n" +
                        "Podłoga na parterze: " + houseDto.getCeilingBelowTheFlatType().getNameInPolish() + "\n" +
                        "Ilość kondygnacji: " + houseDto.getFloorNumberInTheBuilding().getNameInPolish(),
                normalTextFont
        );
        normalCeiling.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Windows and entrance door
        Paragraph headingWindowsAndEntranceDoor = new Paragraph(
                "\nOkna i drzwi wejściowe",
                headingFont
        );
        headingWindowsAndEntranceDoor.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalWindowsAndEntranceDoor = new Paragraph(
                "Typ drzwi wejściowych: " + houseDto.getEntranceDoorType().getNameInPolish() + "\n" +
                        "Materiał ram okiennych: " + houseDto.getWindowFrameMaterial().getNameInPolish() + "\n" +
                        "Liczba szyb: " + houseDto.getNumberOfGlasses().getNameInPolish(),
                normalTextFont

        );
        normalWindowsAndEntranceDoor.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Layout and type of External Walls
        Paragraph headingLayoutAndTypeOfExternalWalls = new Paragraph(
                "\nUkład i rodzaj ścian zewnetrznych",
                headingFont
        );
        headingLayoutAndTypeOfExternalWalls.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalLayoutAndTypeOfExternalWalls = new Paragraph(
                "Typ materiału ścian zewnetrznych: " + houseDto.getExternalMaterialWallsType().getNameInPolish() + "\n" +
                        "Typ materiału ścian zewnętrznych (jeśli zaznaczono inne): " + houseDto.getAnotherExternalMaterialWallsType() + "\n" +
                        "Grubość materiału ścian zewnetrznych w centymetrach: " + houseDto.getExternalMaterialWallsThicknessInCentimeters() + "\n" +
                        "Typ izolacji ścian zewnetrznych: " + houseDto.getExternalIsolationWallsType().getNameInPolish() + "\n" +
                        "Typ izolacji ścian zewnętrznych (jeśli zaznaczono inne): " + houseDto.getAnotherExternalMaterialWallsType() + "\n" +
                        "Grubość izolacji ścian zewnetrznych w centymetrach: " + houseDto.getExternalIsolationWallsThicknessInCentimeters() + "\n" +
                        "Lista ścian domu: \n" + getAllHouseWallsAsString(houseDto.getHauseWallDtoList()) + "\n" +
                        "Czy sa nieogrzewane pomieszczenia w domu: " + houseDto.isAreThereAnyUnheatedRoomsInHouse() + "\n" +
                        "Lista nieogrzewanych pomieszczeń: " + getAllUnheatedRoomsAsString(houseDto.getUnheatedRoomDtoList()) + "\n" +
                        "Czy podczas budowy nastąpiły zmiany w projekcie: " + houseDto.isHouseBuildCorrectly() + "\n" +
                        "Informacja o zmianach w projekcie: " + houseDto.getHouseNotBuildCorrectlyInformation() + "\n" +
                        "Czy dom ma klimatyzacje: " + houseDto.isHasHouseAirConditioning() + "\n" +
                        "Moc klimatyzacji w kW: " + houseDto.getAirConditioningPowerInKw() + "\n" +
                        "Czy jest zainstalowany rekuperator: " + houseDto.isHasInstalledRecuperator() + "\n" +
                        "Model rekuperatora: " + houseDto.getRecuperatorModel() + "\n" +
                        "Czy sa panele słoneczne: " + houseDto.isHasSolarPanels() + "\n" +
                        "Moc i cel paneli słonecznych: " + houseDto.getPowerAndUsageOfSolarPanels(),
                normalTextFont
        );
        normalLayoutAndTypeOfExternalWalls.setAlignment(Paragraph.ALIGN_JUSTIFIED);


//Additional information
        Paragraph headingAdditionalInformation = new Paragraph(
                "\nDodatkowe informacje",
                headingFont
        );
        headingAdditionalInformation.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        Paragraph normalAdditionalInformation = new Paragraph(
                "Dodatkowe informacje:\n" + "\t\t" + houseDto.getAdditionalInformation(),
                normalTextFont
        );
        normalAdditionalInformation.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        
        document.add(titleParagraph);

        document.add(headingClientDataParagraph);
        document.add(normalClientDataParagraph);

        document.add(headingBasicDataOfTheHouse);
        document.add(normalBasicDataOfTheHouse);

        document.add(headingHeating);
        document.add(normalHeating);

        document.add(headingHotWater);
        document.add(normalHotWater);

        document.add(headingVentilation);
        document.add(normalVentilation);

        document.add(headingCeiling);
        document.add(normalCeiling);

        document.add(headingWindowsAndEntranceDoor);
        document.add(normalWindowsAndEntranceDoor);

        document.add(headingLayoutAndTypeOfExternalWalls);
        document.add(normalLayoutAndTypeOfExternalWalls);

        document.add(headingAdditionalInformation);
        document.add(normalAdditionalInformation);

        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    private String getAllHouseWallsAsString(List<HouseWallDto> houseWallDtoList) {
        StringBuffer allHousesWall = new StringBuffer();

        for (int i = 0; i < houseWallDtoList.size(); i++) {
            HouseWallDto houseWall = houseWallDtoList.get(i);

            if (i == 0) {
                allHousesWall.append("     -Strona Świata (drzwi wejściowe): ")
                        .append(houseWall.getWorldPart().getNameInPolish())
                        .append(", Łaczna długość ściany zewnetrznej w metrach: ")
                        .append(houseWall.getTotalLengthOfExternalWallInM())
                        .append("\n");
                continue;
            }

            allHousesWall.append("\t\t ")
                    .append("     -Strona Świata: ")
                    .append(houseWall.getWorldPart().getNameInPolish())
                    .append(", Łaczna długość ściany zewnetrznej w metrach: ")
                    .append(houseWall.getTotalLengthOfExternalWallInM())
                    .append("\n");
        }

        return allHousesWall.toString();
    }

    private String getAllUnheatedRoomsAsString(List<UnheatedRoomDto> unheatedRoomDtoList) {
        StringBuffer allUnheatedRooms = new StringBuffer();

        for (UnheatedRoomDto unheatedRoomDto : unheatedRoomDtoList) {
            allUnheatedRooms.append("\n")
                    .append("\t\t ")
                    .append("     -Rodzaj pomieszczenia: ")
                    .append(unheatedRoomDto.getRoomType().getNameInPolish())
                    .append(", Powierzchnia pomieszczenia w m2: ")
                    .append(unheatedRoomDto.getAreaInSquareM())
                    .append("\n");
        }

        return allUnheatedRooms.toString();
    }

    public byte[] getZipBytes(BuildingDto buildingDto, String title) {
        byte[] pdfBytes = getPdfInBytes(buildingDto);

        List<byte[]> images = new ArrayList<>();
        HouseDto houseDto = findHouseFromBuilding(buildingDto);
        houseDto.getAttachmentDtoList().forEach(attachment -> images.add(attachment.getBytes()));

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
