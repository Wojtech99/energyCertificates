package com.example.energyCertificates.Building.House.Service;

import com.example.energyCertificates.Building.House.Dtoes.HouseWallDto;
import com.example.energyCertificates.Building.House.HouseWall;
import com.example.energyCertificates.Building.House.Mappers.HouseWallMapper;
import com.example.energyCertificates.Building.House.Repos.HouseWallRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class HouseWallService {
    private final HouseWallRepository houseWallRepository;

    public HouseWallService(HouseWallRepository houseWallRepository) {
        this.houseWallRepository = houseWallRepository;
    }

    @Transactional
    public HouseWallDto save(HouseWallDto houseWallDto) {
        HouseWall houseWallToSave = HouseWallMapper.map(houseWallDto);
        HouseWall savedHouseWall = houseWallRepository.save(houseWallToSave);

        return HouseWallMapper.map(savedHouseWall);
    }

    @Transactional
    public void delete(HouseWallDto houseWallDto) {
        HouseWall houseWallToDelete = HouseWallMapper.map(houseWallDto);

        houseWallRepository.deleteById(houseWallToDelete.getId());
    }
}
