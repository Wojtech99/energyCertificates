package com.example.energyCertificates.Client;

import com.example.energyCertificates.Client.Dtoes.ClientDto;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ClientDto saveClient(ClientDto clientDto) {
        ClientDto clientDtoToSave = encodeClientInfo(clientDto);

        Client client = ClientMapper.map(clientDtoToSave);
        Client savedClient = clientRepository.save(client);

        return ClientMapper.map(savedClient);
    }

    private ClientDto encodeClientInfo(ClientDto clientDto) {
        String firstName = passwordEncoder.encode(clientDto.getFirstName());
        String lastName = passwordEncoder.encode(clientDto.getLastName());
        String email = passwordEncoder.encode(clientDto.getEmail());
        String companyName = passwordEncoder.encode(clientDto.getCompanyName());
        String companyAddress = passwordEncoder.encode(clientDto.getCompanyAddress());

        clientDto.setFirstName(firstName);
        clientDto.setLastName(lastName);
        clientDto.setEmail(email);
        clientDto.setCompanyName(companyName);
        clientDto.setCompanyAddress(companyAddress);

        return clientDto;
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
