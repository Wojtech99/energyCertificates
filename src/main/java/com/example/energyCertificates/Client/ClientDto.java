package com.example.energyCertificates.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.energyCertificates.Client.Client}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String pdfFile;
    private String companyName;
    private int CompanyNumber;
    private String companyAddress;
    private boolean dataAreGenuineStatement;
    private boolean clientConfirmsCompanyTerms;
    private boolean orderIsPaid;
}