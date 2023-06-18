package com.example.testspringweb.service;

import com.example.testspringweb.model.response.ProductResponse;
import com.example.testspringweb.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    ProductRepository productRepository;
    ObjectMapper objectMapper;

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> objectMapper.convertValue(product,ProductResponse.class))
                .collect(Collectors.toList());
    }
}
