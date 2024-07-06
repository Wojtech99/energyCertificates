package com.example.energyCertificates.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.energyCertificates.Data.Data}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto implements Serializable {
    private Long id;
    private String name;
    private String type;
    private byte[] bytes;

    public DataDto(String name, String type, byte[] bytes) {
        this.name = name;
        this.type = type;
        this.bytes = bytes;
    }
}