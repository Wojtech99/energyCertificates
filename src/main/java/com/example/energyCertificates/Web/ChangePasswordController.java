package com.example.energyCertificates.Web;

import com.example.energyCertificates.User.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
    private final UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/change-password")
    String changePasswordForm() {
        return "change-password";
    }

    @PostMapping("/change-password/save")
    String changePassword(@RequestParam String newPassword) {
        userService.changePassword(newPassword);

        return "redirect:/logout";
    }
}
