package com.example.bus_management_2.controller;

import com.example.bus_management_2.entity.Route;
import com.example.bus_management_2.model.request.RouteCreateRequest;
import com.example.bus_management_2.model.request.RouteUpdateRequest;
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
public class RouteController {

    RouteService routeService;

    @GetMapping("/bus")
    public String getAllRoute(Model model) {
        List<Route> buslines = routeService.getAllRoute();
        model.addAttribute("danhSachTuyen", buslines);
        model.addAttribute("tuyenTaoMoi",new RouteCreateRequest());
        return "route-list";
    }

    @PostMapping("/bus")
    public String createNewRoute(@ModelAttribute("tuyenTaoMoi") @Valid RouteCreateRequest routeCreateRequest) {
        routeService.saveRoute(routeCreateRequest);
        return "redirect:/bus";
    }

    @GetMapping("/bus/{id}/delete")
    public String deleteRoute(@PathVariable int id) {
        routeService.delete(id);
        return "redirect:/bus";
    }

    @GetMapping("/bus/{id}/edit")
    public String forwardToEditForm(@PathVariable("id") int id, Model model) {
        RouteUpdateRequest routeUpdateRequest = routeService.findById(id);
        model.addAttribute("tuyenCapNhatMoi", routeUpdateRequest);
        return "edit-route";
    }

    @PostMapping("/bus/update")
    public String updateRoute(@ModelAttribute("tuyenCapNhatMoi") @Valid RouteUpdateRequest routeUpdateRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tuyenCapNhatMoi", routeUpdateRequest);
            return "update-route";
        }
        routeService.updateRoute(routeUpdateRequest);
        return "redirect:/bus";
    }

    @GetMapping("/api/bus/{id}")
    public ResponseEntity<?> getRoute(@PathVariable Integer id) {
        return ResponseEntity.ok(routeService.findByIdVer2(id));
    }
    @PutMapping("/api/bus/{id}")
    public ResponseEntity<?> updateRoute(@PathVariable Integer id, @RequestBody @Valid RouteUpdateRequest routeUpdateRequest, Model model) {
        routeUpdateRequest.setId(id);
        routeService.updateRoute(routeUpdateRequest);
        return ResponseEntity.ok(null);
    }

}
