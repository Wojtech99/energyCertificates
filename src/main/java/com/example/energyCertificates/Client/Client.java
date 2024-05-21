package com.example.energyCertificates.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Client(String firstName, String lastName, String email, int phoneNumber, String pdfFile, String companyName, int companyNumber, String companyAddress, boolean dataAreGenuineStatement, boolean clientConfirmsCompanyTerms, boolean orderIsPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pdfFile = pdfFile;
        this.companyName = companyName;
        CompanyNumber = companyNumber;
        this.companyAddress = companyAddress;
        this.dataAreGenuineStatement = dataAreGenuineStatement;
        this.clientConfirmsCompanyTerms = clientConfirmsCompanyTerms;
        this.orderIsPaid = orderIsPaid;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyNumber() {
        return CompanyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        CompanyNumber = companyNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public boolean isDataAreGenuineStatement() {
        return dataAreGenuineStatement;
    }

    public void setDataAreGenuineStatement(boolean dataAreGenuineStatement) {
        this.dataAreGenuineStatement = dataAreGenuineStatement;
    }

    public boolean isClientConfirmsCompanyTerms() {
        return clientConfirmsCompanyTerms;
    }

    public void setClientConfirmsCompanyTerms(boolean clientConfirmsCompanyTerms) {
        this.clientConfirmsCompanyTerms = clientConfirmsCompanyTerms;
    }

    public boolean isOrderIsPaid() {
        return orderIsPaid;
    }

    public void setOrderIsPaid(boolean orderIsPaid) {
        this.orderIsPaid = orderIsPaid;
    }
}
