package com.example.energyCertificates.Building;

import com.example.energyCertificates.Building.Enums.BuildingType;
import com.example.energyCertificates.Building.Flat.service.FlatService;
import com.example.energyCertificates.Building.House.Service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

@Service
public class BuildingService {
    private final HouseService houseService;
    private final FlatService flatService;

    public BuildingService(HouseService houseService, FlatService flatService) {
        this.houseService = houseService;
        this.flatService = flatService;
    }

    TreeSet<BuildingDto> getAllBuildings() {
        List<BuildingDto> houseDtoList = houseService
                .getAllHousesWithCondition(Objects::nonNull).stream()
                .map(BuildingMapper::map)
                .toList();
        List<BuildingDto> flatDtoList = flatService
                .getFlatWithCondition(Objects::nonNull).stream()
                .map(BuildingMapper::map)
                .toList();
        TreeSet<BuildingDto> buildingDtoTreeSet = new TreeSet<>();

        for (BuildingDto buildingDto : houseDtoList) {
            buildingDto.setBuildingType(BuildingType.HOUSE);
        }

        for (BuildingDto buildingDto : flatDtoList) {
            buildingDto.setBuildingType(BuildingType.FLAT);
        }

        buildingDtoTreeSet.addAll(houseDtoList);
        buildingDtoTreeSet.addAll(flatDtoList);

        return buildingDtoTreeSet;
    }

    void deleteBuilding(BuildingDto buildingDto) {
        if (buildingDto.getBuildingType().equals(BuildingType.HOUSE)) {
            houseService.delete(buildingDto);
        } else {
            flatService.delete(buildingDto);
        }
    }

    public String changePolishLetters(String title) {
        char[] lettersAsChars = title.toLowerCase().toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < lettersAsChars.length; i++) {
            if (lettersAsChars[i] == 'ś') {
                stringBuffer.append('s');
            } else if (lettersAsChars[i] == 'ć') {
                stringBuffer.append('c');
            } else if (lettersAsChars[i] == 'ź') {
                stringBuffer.append('z');
            } else if (lettersAsChars[i] == 'ż') {
                stringBuffer.append('z');
            } else if (lettersAsChars[i] == 'ń') {
                stringBuffer.append('n');
            } else if (lettersAsChars[i] == 'ó') {
                stringBuffer.append('o');
            } else if (lettersAsChars[i] == 'ł') {
                stringBuffer.append('l');
            } else if (lettersAsChars[i] == 'ą') {
                stringBuffer.append('a');
            } else if (lettersAsChars[i] == 'ę') {
                stringBuffer.append('e');
            } else {
                stringBuffer.append(lettersAsChars[i]);
            }
        }

        return stringBuffer.toString();
    }
}
