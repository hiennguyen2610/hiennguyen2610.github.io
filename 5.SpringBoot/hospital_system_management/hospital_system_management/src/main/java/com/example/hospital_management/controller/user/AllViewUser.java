package com.example.hospital_management.controller.user;

import com.example.hospital_management.model.request.DoctorSearchRequest;
import com.example.hospital_management.model.response.CommonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllViewUser {

    @GetMapping("/appointment")
    public String searchDoctor() {
        return "anonymous/appointment";
    }
}
