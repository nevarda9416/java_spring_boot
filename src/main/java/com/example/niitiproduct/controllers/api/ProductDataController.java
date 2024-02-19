package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductDataController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/all")
    public ResponseEntity<Object> index() {
        return productService.getAllProducts();
    }
}