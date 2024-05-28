package com.example.energyCertificates.Building.House.Repos;

import com.example.energyCertificates.Building.House.UnheatedRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnheatedRoomRepository extends CrudRepository<UnheatedRoom, Long> {
}
