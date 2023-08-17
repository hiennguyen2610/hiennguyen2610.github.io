package com.example.hospital_management.controller.admin;

import com.example.hospital_management.entity.Service;
import com.example.hospital_management.model.request.*;
import com.example.hospital_management.model.response.ErrorResponse;
import com.example.hospital_management.service.SvService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping()
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ServiceController {

    SvService svService;

    @PostMapping("/api/v1/admin/services")
    public ResponseEntity<?> createService(@RequestBody ServiceRequest serviceRequest) {
        try {
            Service service = svService.createService(serviceRequest.getName(), serviceRequest.getPrice());
            return ResponseEntity.ok(service);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/v1/admin/services/{id}")
    public ResponseEntity<?> updateService(@PathVariable("id") Long id, @RequestBody ServiceRequest serviceRequest) {
        try {
            Service service = svService.updateService(id, serviceRequest.getName(), serviceRequest.getPrice());
            return ResponseEntity.ok(service);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/v1/admin/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") Long id) {
        svService.deleteService(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}

