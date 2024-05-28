package com.example.energyCertificates.Client;

public class ClientMapper {
    public static Client map(ClientDto clientDto) {
        Client client = new Client(
                clientDto.getFirstName(),
                clientDto.getLastName(),
                clientDto.getEmail(),
                clientDto.getPhoneNumber(),
                clientDto.getPdfFile(),
                clientDto.getCompanyName(),
                clientDto.getCompanyNumber(),
                clientDto.getCompanyAddress(),
                clientDto.isDataAreGenuineStatement(),
                clientDto.isClientConfirmsCompanyTerms(),
                clientDto.isOrderIsPaid()
        );

        client.setId(clientDto.getId());

        return client;
    }

    public static ClientDto map(Client client) {
        return new ClientDto(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber(),
                client.getPdfFile(),
                client.getCompanyName(),
                client.getCompanyNumber(),
                client.getCompanyAddress(),
                client.isDataAreGenuineStatement(),
                client.isClientConfirmsCompanyTerms(),
                client.isOrderIsPaid()
        );
    }
}
