package com.example.energyCertificates.Building.House;

import com.example.energyCertificates.Building.House.Dtoes.HouseDto;
import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.Dtoes.UnheatedRoomDto;
import com.example.energyCertificates.Building.House.Enums.RoomType;
import com.example.energyCertificates.Building.House.Enums.WorldParts;
import com.example.energyCertificates.Building.House.Service.HouseService;
import com.example.energyCertificates.Building.House.Service.HouseWallService;
import com.example.energyCertificates.Building.House.Service.UnheatedRoomService;
import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.ClientService;
import com.example.energyCertificates.Data.DataDto;
import com.example.energyCertificates.Data.Service.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {


    @Mock
    private ClientService clientService;
    @Mock
    private HouseWallService houseWallService;
    @Mock
    private UnheatedRoomService unheatedRoomService;
    @Mock
    private DataService dataService;
    @InjectMocks
    private HouseService houseService;

    private HouseDto houseDto;
    private ClientDto clientDto;
    private HouseWallDto houseWallDto;
    private HouseWallDto houseWallDto2;
    private UnheatedRoomDto unheatedRoomDto;
    private UnheatedRoomDto unheatedRoomDto2;
    private DataDto dataDto;

    @BeforeEach
    public void setUp() {
        clientDto = new ClientDto();
        clientDto.setFirstName("ala");
        clientDto.setEmail("ala@makota.com");
        clientDto.setPhoneNumber(123456789);


        houseWallDto = new HouseWallDto();
        houseWallDto.setWorldPart(WorldParts.EAST);
        houseWallDto.setTotalLengthOfExternalWallInM(2);

        houseWallDto2 = new HouseWallDto();
        houseWallDto2.setWorldPart(WorldParts.NULL);
        houseWallDto2.setTotalLengthOfExternalWallInM(0);


        unheatedRoomDto = new UnheatedRoomDto();
        unheatedRoomDto.setRoomType(RoomType.ATTIC);
        unheatedRoomDto.setAreaInSquareM(3);

        unheatedRoomDto2 = new UnheatedRoomDto();
        unheatedRoomDto2.setRoomType(RoomType.NULL);
        unheatedRoomDto2.setAreaInSquareM(0);


        dataDto = new DataDto();
        dataDto.setName("name");

        houseDto = new HouseDto();
        houseDto.setStreet("street");
        houseDto.setHouseNumber(12);
        houseDto.setClientDto(clientDto);
        houseDto.setHauseWallDtoList(new ArrayList<>());
        houseDto.getHauseWallDtoList().add(houseWallDto);
        houseDto.getHauseWallDtoList().add(houseWallDto2);
        houseDto.setUnheatedRoomDtoList(new ArrayList<>());
        houseDto.getUnheatedRoomDtoList().add(unheatedRoomDto);
        houseDto.getUnheatedRoomDtoList().add(unheatedRoomDto2);
        houseDto.setAttachmentDtoList(new ArrayList<>());
        houseDto.getAttachmentDtoList().add(dataDto);
    }

    @Test
    public void testSave() {
        when(clientService.saveClient(any(ClientDto.class))).thenReturn(clientDto);
        when(houseWallService
                .save(any(HouseWallDto.class)))
                .thenReturn(houseWallDto, houseWallDto2);
        when(unheatedRoomService
                .save(any(UnheatedRoomDto.class)))
                .thenReturn(unheatedRoomDto, unheatedRoomDto2);
        when(dataService
                .save(any(DataDto.class)))
                .thenReturn(dataDto);
        when(houseService.saveHouse(any(HouseDto.class), any()))
                .thenReturn(houseDto);
    }
}
