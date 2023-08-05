package com.example.hospital_management.controller.admin;

import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Speciality;
import com.example.hospital_management.model.response.DoctorResponse;
import com.example.hospital_management.service.DoctorService;
import com.example.hospital_management.service.SpecialityService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class WebAdminController {

    DoctorService doctorService;
    SpecialityService specialityService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/admin/dashboard")
    public String adminHome() {
        return "admin/index";
    }

    @GetMapping("/admin/departments")
    public String department(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "6") Integer pageSize, Model model) {
        Page<Speciality> pageInfo = specialityService.getAllSpecialityPage(page, pageSize);
        List<Speciality> specialityList = specialityService.getAllSpecialities();
        model.addAttribute("listAllSpecialities", specialityList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "admin/departments";
    }

    @GetMapping("/admin/add-department")
    public String addDepartment() {
        return "admin/add-department";
    }


    @GetMapping("/admin/doctors")
    public String doctorList(Model model) {
        List<DoctorResponse> doctorResponsePage = doctorService.getAllDoctorResponse();
        List<Speciality> specialityList = specialityService.getAllSpecialities();
        model.addAttribute("getAllDoctor", doctorResponsePage);
        model.addAttribute("listAllSpecialities", specialityList);

        return "admin/doctors";
    }

    @GetMapping("/admin/add-doctor")
    public String addDoctor(Model model) {
        model.addAttribute("listAllSpecialities", specialityService.getAllSpecialities());
        return "admin/add-doctor";
    }


}
