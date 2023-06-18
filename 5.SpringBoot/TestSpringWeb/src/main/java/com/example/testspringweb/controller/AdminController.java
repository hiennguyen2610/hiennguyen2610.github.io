package com.example.testspringweb.controller;

import com.example.testspringweb.exception.NotFoundException;
import com.example.testspringweb.model.request.ProductRequest;
import com.example.testspringweb.model.response.ProductResponse;
import com.example.testspringweb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("/api/v1/product")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        ProductResponse productResponse = productService.saveProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/api/v1/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRequest productRequest) throws NotFoundException {
        ProductResponse productResponse = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(productResponse);
    }
}
