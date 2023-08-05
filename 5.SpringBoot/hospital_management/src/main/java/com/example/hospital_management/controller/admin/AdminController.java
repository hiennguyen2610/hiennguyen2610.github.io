package com.example.hospital_management.controller.admin;

import com.example.hospital_management.entity.Speciality;
import com.example.hospital_management.model.request.DoctorRequest;
import com.example.hospital_management.model.request.LoginRequest;
import com.example.hospital_management.model.request.RegistrationRequest;
import com.example.hospital_management.model.request.SpecialityRequest;
import com.example.hospital_management.model.response.ErrorResponse;
import com.example.hospital_management.service.DoctorService;
import com.example.hospital_management.service.SpecialityService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
@RequestMapping("api/v1/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AdminController {

    DoctorService doctorService;
    SpecialityService specialityService;

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable("id") Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody @Valid RegistrationRequest registrationRequest) {
        doctorService.updateDoctor(id, registrationRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{doctor_id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/specialities")
    public ResponseEntity<?> createSpeciality(@RequestBody SpecialityRequest specialityRequest) {
        try {
            Speciality speciality = specialityService.create(specialityRequest.getName(), specialityRequest.getDescription());
            return ResponseEntity.ok(speciality);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/specialities/{id}")
    public ResponseEntity<?> getSpeciality(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(specialityService.getSpeciality(id));
    }

    @PutMapping("/specialities/{id}")
    public ResponseEntity<?> updateSpeciality(@PathVariable("id") Integer id, @RequestBody SpecialityRequest specialityRequest) {
        try {
            Speciality speciality = specialityService.update(id, specialityRequest.getName(), specialityRequest.getDescription());
            return ResponseEntity.ok(speciality);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("specialities/{id}")
    public ResponseEntity<?> deleteSpeciality(@PathVariable("id") Long id) {
        specialityService.deleteSpeciality(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
