package com.example.energyCertificates.Client;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = ClientMapper.map(clientDto);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.map(savedClient);
    }

    @Transactional
    public void deleteClient(ClientDto clientDto) {
        Client clientToDelete = ClientMapper.map(clientDto);
        clientRepository.deleteByEmail(clientToDelete.getEmail());
    }

    public Optional<ClientDto> findClientByEmail(String email) {
        Optional<Client> clientOptional = clientRepository.findByEmail(email);

        if (clientOptional.isEmpty()) {
            return Optional.empty();
        }

        return clientOptional.map(ClientMapper::map);
    }
}
