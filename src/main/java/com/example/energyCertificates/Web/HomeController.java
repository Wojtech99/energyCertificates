package com.example.energyCertificates.Web;

import com.example.energyCertificates.Client.Dtoes.ClientDto;
import com.example.energyCertificates.Client.Dtoes.PrimaryClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("primaryClient", new PrimaryClientDto());

        return "index";
    }

    @GetMapping("/regulations")
    String regulations() {
        return "regulations";
    }

    @GetMapping("/privacy-policy")
    String privacyPolicy() {
        return "privacy-policy";
    }
}
