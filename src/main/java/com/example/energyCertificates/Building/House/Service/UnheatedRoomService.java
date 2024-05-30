package com.example.energyCertificates.Building.House.Service;

import com.example.energyCertificates.Building.House.Dtoes.UnheatedRoomDto;
import com.example.energyCertificates.Building.House.Mappers.UnheatedRoomMapper;
import com.example.energyCertificates.Building.House.Repos.UnheatedRoomRepository;
import com.example.energyCertificates.Building.House.UnheatedRoom;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UnheatedRoomService {
    private final UnheatedRoomRepository unheatedRoomRepository;

    public UnheatedRoomService(UnheatedRoomRepository unheatedRoomRepository) {
        this.unheatedRoomRepository = unheatedRoomRepository;
    }

    @Transactional
    public UnheatedRoomDto save(UnheatedRoomDto unheatedRoomDto) {
        UnheatedRoom unheatedRoomToSave = UnheatedRoomMapper.map(unheatedRoomDto);
        UnheatedRoom savedUnheatedRoom = unheatedRoomRepository.save(unheatedRoomToSave);

        return UnheatedRoomMapper.map(savedUnheatedRoom);
    }

    @Transactional
    public void delete(UnheatedRoomDto unheatedRoomDto) {
        UnheatedRoom unheatedRoomToDelete = UnheatedRoomMapper.map(unheatedRoomDto);

        unheatedRoomRepository.deleteById(unheatedRoomToDelete.getId());
    }
}
