package com.example.bus_management_2.controller;

import com.example.bus_management_2.entity.Driver;
import com.example.bus_management_2.entity.Route;
import com.example.bus_management_2.model.request.DriverAssignmentCreateRequest;
import com.example.bus_management_2.model.request.DriverAssignmentUpdateRequest;
import com.example.bus_management_2.service.DriverAssignmentService;
import com.example.bus_management_2.service.DriverService;
import com.example.bus_management_2.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class DriverAssignmentController {

    DriverAssignmentService driverAssignmentService;
    DriverService driverService;
    RouteService routeService;

    @GetMapping("/assignments")
    public String getAllDriverAssignment(Model model) {
        List<DriverAssignmentCreateRequest> driverAssignments = driverAssignmentService.getAllDriverAssignment();
        getList(model);
        model.addAttribute("danhSachDriverAssignment", driverAssignments);
        model.addAttribute("themluotphancong", new DriverAssignmentCreateRequest());
        return "driver-assignment-list";
    }

    @PostMapping("/assignments")
    public String createNewDriverAssignment(@ModelAttribute("themluotphancong") @Valid DriverAssignmentCreateRequest driverAssignmentCreateRequest, Model model) {
        getList(model);
        driverAssignmentService.createNewDriverAssignment(driverAssignmentCreateRequest);
        return "redirect:/assignments";
    }

    @GetMapping("/assignments/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model) {
        DriverAssignmentCreateRequest driverAssignmentCreateRequest = driverAssignmentService.findDriverAssignmentById(id);
            getList(model);
        model.addAttribute("driverAssignmentCapNhatMoi", driverAssignmentCreateRequest);
        return "edit-assignment";
    }

    @PostMapping("/assignments/update")
    public String update(@ModelAttribute("driverAssignmentCapNhatMoi")  @Valid DriverAssignmentUpdateRequest driverAssignmentUpdateRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("driverAssignmentCapNhatMoi", driverAssignmentUpdateRequest);
            return "update-assignment";
        }
        getList(model);
        driverAssignmentService.update(driverAssignmentUpdateRequest);
        return "redirect:/assignments";

    }
    private void getList(Model model) {
        List<Driver> driverCreateRequests = driverService.getAllDriver();
        List<Route> routeCreateRequests = routeService.getAllRoute();

        model.addAttribute("danhSachDriver", driverCreateRequests);
        model.addAttribute("danhSachTuyen", routeCreateRequests);
    }
    @GetMapping("/api/assignments/{id}")
    public ResponseEntity<?> getDriverAssignment(@PathVariable Integer id) {
        return ResponseEntity.ok(driverAssignmentService.findByIdVer2(id));
    }
    @PutMapping("/api/assignments/{id}")
    public ResponseEntity<?> updateDriverAssignment(@PathVariable Integer id, @RequestBody @Valid DriverAssignmentUpdateRequest driverAssignmentUpdateRequest, Model model) {
        getList(model);
        driverAssignmentUpdateRequest.setId(id);
        driverAssignmentService.update(driverAssignmentUpdateRequest);
        return ResponseEntity.ok(null);
    }
}



