package com.example.energyCertificates.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    String home() {
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
