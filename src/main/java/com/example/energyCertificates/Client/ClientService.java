package com.example.energyCertificates.Client;

import com.example.energyCertificates.Client.Dtoes.ClientDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void deleteClient(String email) {
        clientRepository.deleteByEmail(email);
    }

    public List<ClientDto> getAllClients() {
        return clientRepository.getAll().stream()
                .map(ClientMapper::map)
                .toList();
    }

    public Optional<ClientDto> findClientByEmail(String email) {
        Optional<Client> clientOptional = clientRepository.findByEmail(email);

        if (clientOptional.isEmpty()) {
            return Optional.empty();
        }

        return clientOptional.map(ClientMapper::map);
    }
}
