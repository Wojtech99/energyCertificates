package com.example.energyCertificates.Client;

import com.example.energyCertificates.Client.Dtoes.ClientDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private ClientService clientService;

    private ClientDto clientDto;

    @BeforeEach
    public void setUp() {
        clientDto = new ClientDto();
        clientDto.setFirstName("ala");
        clientDto.setEmail("ala@makota.com");
        clientDto.setPhoneNumber(123456789);
    }

    @Test
    public void testSaveClient() {
        when(clientService
                .saveClient(any(ClientDto.class)))
                .thenReturn(clientDto);
    }
}
