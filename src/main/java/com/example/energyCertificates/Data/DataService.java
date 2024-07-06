package com.example.energyCertificates.Data;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional
    public DataDto save(DataDto dataDto) {
        Data dataToSave = DataMapper.map(dataDto);
        Data savedData = dataRepository.save(dataToSave);

        return DataMapper.map(savedData);
    }

    @Transactional
    public void delete(DataDto dataDto) {
        Data dataToDelete = DataMapper.map(dataDto);

        dataRepository.deleteById(dataToDelete.getId());
    }
}
