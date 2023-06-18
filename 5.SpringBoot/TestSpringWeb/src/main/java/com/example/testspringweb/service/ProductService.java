package com.example.testspringweb.service;

import com.example.testspringweb.entity.Product;
import com.example.testspringweb.exception.NotFoundException;
import com.example.testspringweb.model.request.ProductRequest;
import com.example.testspringweb.model.response.ProductResponse;
import com.example.testspringweb.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;
    ObjectMapper objectMapper;

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> objectMapper.convertValue(product,ProductResponse.class))
                .collect(Collectors.toList());
    }

    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = objectMapper.convertValue(productRequest, Product.class);
        productRepository.save(product);
        return objectMapper.convertValue(product, ProductResponse.class);
    }

    public ProductResponse updateProduct(Integer id, ProductRequest productRequest) throws NotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("không tìm thấy sp")
                );
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescrible(productRequest.getDescrible());
        product.setAvatar(productRequest.getAvatar());
        productRepository.save(product);
        return objectMapper.convertValue(product, ProductResponse.class);
    }
}
