package com.example.bus_management.controller;

import com.example.bus_management.entity.Driver;
import com.example.bus_management.model.DriverModel;
import com.example.bus_management.service.DriverService;
import com.example.bus_management.statics.Level;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/drivers")
public class DriverController {

    DriverService driverService;

    @GetMapping
    public String getDriver(Model model) {
        List<DriverModel> driverModelList = driverService.getAllDriver();
        model.addAttribute("danhSachLaiXe", driverModelList);
        return "driver-list";
    }

    @GetMapping("create-form")
    public String forwardToCreateForm(Model model, DriverModel driverModel) {
        getLevel(model);

        model.addAttribute("laiXeMuonTaoMoi", driverModel);
        return "create-driver";
    }
    private void getLevel(Model model) {
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("levels", levels);
    }

    @PostMapping
    public String createNewDriver(@ModelAttribute("laiXeMuonTaoMoi") @Valid DriverModel driverModel, Errors errors, Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            getLevel(model);
            return "create-driver";
        }
        driverService.createNewDriver(driverModel);
        return "redirect:/drivers";
    }

    @GetMapping("/update/{id}")
    public String forwardToUpdateForm(@PathVariable int id, Model model) {
        DriverModel driverModel = driverService.findDriverModelById(id);
        getLevel(model);
        model.addAttribute("laiXeMuonSua", driverModel);
        return "update-driver";
    }

    @PostMapping("/update")
    public String updateDriver(@ModelAttribute("laiXeMuonSua") @Valid DriverModel driverModel, Errors errors, Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            getLevel(model);
            return "update-driver";
        }
        driverService.updateDriver(driverModel);
        return "redirect:/drivers";
    }

    @GetMapping("/delete/{id}")
    public String deleteDriver(@PathVariable int id) {
        driverService.deleteDriver(id);
        return "redirect:/drivers";
    }
}
