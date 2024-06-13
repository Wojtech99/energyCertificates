package com.example.energyCertificates.Client.Dtoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryClientDto {
    private String firstName;
    private String email;
    private int phoneNumber;
    private String message;
}
