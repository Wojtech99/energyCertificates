package com.example.energyCertificates.Building.House.Service;

import com.example.energyCertificates.Building.FilteringCondition;
import com.example.energyCertificates.Building.House.Dtoes.HouseDto;
import com.example.energyCertificates.Building.House.House;
import com.example.energyCertificates.Building.House.Mappers.HouseMapper;
import com.example.energyCertificates.Building.House.Repos.HouseRepository;
import com.example.energyCertificates.Data.DataService;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public class HouseService {
    private final HouseRepository houseRepository;
    private final HouseWallService houseWallService;
    private final UnheatedRoomService unheatedRoomService;
    private final DataService dataService;

    public HouseService(HouseRepository houseRepository, HouseWallService houseWallService, UnheatedRoomService unheatedRoomService, DataService dataService) {
        this.houseRepository = houseRepository;
        this.houseWallService = houseWallService;
        this.unheatedRoomService = unheatedRoomService;
        this.dataService = dataService;
    }

    @Transactional
    public HouseDto save(HouseDto houseDto) {
        House houseToSave = HouseMapper.map(houseDto);

        houseDto.getHauseWallDtoList().forEach(houseWallService::save);
        houseDto.getUnheatedRoomDtoList().forEach(unheatedRoomService::save);
        houseDto.getAttachmentDtoList().forEach(dataService::save);

        House savedHouse = houseRepository.save(houseToSave);

        return HouseMapper.map(savedHouse);
    }

    @Transactional
    public void delete(HouseDto houseDto) {
        houseDto.getHauseWallDtoList().forEach(houseWallService::delete);
        houseDto.getUnheatedRoomDtoList().forEach(unheatedRoomService::delete);
        houseDto.getAttachmentDtoList().forEach(dataService::delete);

        House houseToDelete = HouseMapper.map(houseDto);
        houseRepository.deleteById(houseDto.getId());
    }

    public List<HouseDto> getAllHousesWithCondition(FilteringCondition FilteringCondition) {
        List<House> houseList = houseRepository.getAll();
        List<HouseDto> houseDtoList = houseList.stream().map(HouseMapper::map).toList();
        List<HouseDto> filteredHouseDtoList = new ArrayList<>();

        for (HouseDto houseDto : houseDtoList) {
            if (FilteringCondition.filter(houseDto)) {
                filteredHouseDtoList.add(houseDto);
            }
        }

        return filteredHouseDtoList;
    }
}
