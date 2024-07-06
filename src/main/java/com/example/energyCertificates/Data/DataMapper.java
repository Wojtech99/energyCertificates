package com.example.energyCertificates.Data;

import org.springframework.stereotype.Component;

@Component
public class DataMapper {
    public static Data map(DataDto dataDto) {
        Data data = new Data(
                dataDto.getName()
        );

        data.setId(dataDto.getId());
        data.setType(dataDto.getType());
        data.setBytes(dataDto.getBytes());

        return data;
    }

    public static DataDto map(Data data) {
        return new DataDto(
                data.getId(),
                data.getName(),
                data.getType(),
                data.getBytes()
        );
    }
}
