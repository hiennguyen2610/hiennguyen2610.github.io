package com.example.hospital_management.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "anonymous/login";
    }

    @GetMapping("/admin")
    public String adminHome() {
        return "admin/index";
    }
}
