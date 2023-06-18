package com.example.testspringweb.controller;

import com.example.testspringweb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class AdminController {

    ProductService productService;
    //
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "adminPage";
    }
    
}
