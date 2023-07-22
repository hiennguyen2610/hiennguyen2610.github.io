package com.example.hospital_management.controller.admin;

import com.example.hospital_management.model.request.LoginRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/admin/dashboard")
    public String adminHome() {
        return "admin/index";
    }

    @GetMapping("/doctors")
    public String doctorList() {
        return "admin/doctors";
    }

    @GetMapping("/add-doctor")
    public String addDoctor(Model model) {
        return "admin/add-doctor";
    }

}
