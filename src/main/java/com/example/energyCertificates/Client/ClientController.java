package com.example.energyCertificates.Client;

import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.Dtoes.PrimaryClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list-of-clients")
    String showClientsList(Model model) {
        List<ClientDto> clientDtoList = clientService.getAllClients();
        model.addAttribute("clientList", clientDtoList);

        return "client-list";
    }

    @PostMapping("/send-form")
    String saveClientAndSendHimEmail(@ModelAttribute("primaryClient") PrimaryClientDto primaryClientDto) {
        clientService.saveClient(ClientMapper.map(primaryClientDto));

        return "redirect:/";
    }

    /**
     * delete client by email
     * @param email Client's email
     * @return "List of client" page
     */
    @RequestMapping(
            value = "/client/delete/{email}",
            method = {RequestMethod.GET, RequestMethod.DELETE}
    )
    String deleteClientByEmail(@PathVariable("email") String email) {
        clientService.deleteClient(email);

        return "redirect:/list-of-clients";
    }

    @GetMapping("/ready/ready-form")
    String showReadyForm(Model model) {
        model.addAttribute("client", new ClientDto());

        return "new-ready-form";
    }
}
