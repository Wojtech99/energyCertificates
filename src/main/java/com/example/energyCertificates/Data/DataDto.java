package com.example.energyCertificates.Data;

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

    public DataDto(String name) {
        this.name = name;
    }
}