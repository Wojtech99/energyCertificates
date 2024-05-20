package com.example.energyCertificates.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String pdfFile;
    //--- --- --- --- --- ---
    private String companyName;
    private int CompanyNumber;
    private String companyAddress;
    //--- --- --- --- --- ---
    private boolean dataAreGenuineStatement;
    private boolean clientConfirmsCompanyTerms;
    //--- --- --- --- --- ---
    private boolean orderIsPaid;

    public Client() {}

    public Client(String firstName, String lastName, String email, int phoneNumber, String pdfFile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pdfFile = pdfFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }
}
