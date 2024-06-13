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
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public HouseDto saveHouse(HouseDto houseDto) {

        ClientDto clientDtoToSave = houseDto.getClientDto();
        ClientDto savedClient = clientService.saveClient(clientDtoToSave);
        houseDto.setClientDto(savedClient);


        for (int i = 0; i < houseDto.getHauseWallDtoList().size(); i++) {
            HouseWallDto houseWallDto = houseDto.getHauseWallDtoList().get(i);

            if (houseWallDto.getWorldPart().equals(WorldParts.NULL)) {
                continue;
            }

            HouseWallDto savedHouseWallDto = houseWallService.save(houseWallDto);

            houseDto.getHauseWallDtoList().set(i, savedHouseWallDto);
        }

        for (int i = 0; i < houseDto.getUnheatedRoomDtoList().size(); i++) {
            UnheatedRoomDto unheatedRoomDto = houseDto.getUnheatedRoomDtoList().get(i);

            if (unheatedRoomDto.getRoomType().equals(RoomType.NULL)) {
                continue;
            }

            UnheatedRoomDto savedUnheatedRoomDto = unheatedRoomService.save(unheatedRoomDto);

            houseDto.getUnheatedRoomDtoList().set(i, savedUnheatedRoomDto);
        }

        for (int i = 0; i < houseDto.getAttachmentDtoList().size(); i++) {
            DataDto attachment = houseDto.getAttachmentDtoList().get(i);

            DataDto savedAttachment = dataService.save(attachment);

            houseDto.getAttachmentDtoList().set(i, savedAttachment);
        }


        HouseDto savedHouse = save(houseDto);

        return savedHouse;
    }

    @Transactional
    public HouseDto save(HouseDto houseDto) {
        House houseToSave = HouseMapper.map(houseDto);
        House savedHouse = houseRepository.save(houseToSave);

        return HouseMapper.map(savedHouse);
    }

    private HouseDto findAndDelete(BuildingDto buildingDto) {
        House houseToDelete = houseRepository.getByCityAndStreetAndHouseNumberAndPostalCodeAndSendFormDate(
                buildingDto.getCity(),
                buildingDto.getStreet(),
                buildingDto.getHouseNumber(),
                buildingDto.getPostalCode(),
                buildingDto.getDate()
        );

        return HouseMapper.map(houseToDelete);
    }

    @Transactional
    public void delete(BuildingDto buildingDto) {
        HouseDto houseDto = findAndDelete(buildingDto);

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
}
