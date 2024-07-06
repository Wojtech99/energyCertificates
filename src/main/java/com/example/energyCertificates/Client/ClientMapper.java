package com.example.energyCertificates.Client;

import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.Dtoes.PrimaryClientDto;

public class ClientMapper {
    public static Client map(ClientDto clientDto) {
        Client client = new Client(
                clientDto.getFirstName(),
                clientDto.getLastName(),
                clientDto.getEmail(),
                clientDto.getPhoneNumber(),
                clientDto.getPdfFile(),
                clientDto.getMessage(),
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
                client.getMessage(),
                client.getCompanyName(),
                client.getCompanyNumber(),
                client.getCompanyAddress(),
                client.isDataAreGenuineStatement(),
                client.isClientConfirmsCompanyTerms(),
                client.isOrderIsPaid()
        );
    }

    public static ClientDto map(PrimaryClientDto primaryClientDto) {
        ClientDto clientDto = new ClientDto();

        clientDto.setFirstName(primaryClientDto.getFirstName());
        clientDto.setLastName("");
        clientDto.setEmail(primaryClientDto.getEmail());
        clientDto.setPhoneNumber(primaryClientDto.getPhoneNumber());
        clientDto.setMessage(primaryClientDto.getMessage());
        clientDto.setCompanyName("");
        clientDto.setCompanyAddress("");
        clientDto.setCompanyNumber(0);
        clientDto.setClientConfirmsCompanyTerms(false);
        clientDto.setDataAreGenuineStatement(false);

        return clientDto;
    }
}
