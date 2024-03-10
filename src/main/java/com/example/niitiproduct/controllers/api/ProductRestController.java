package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductService productService;

    @GetMapping("/products/all")
    public ResponseEntity<Object> getAllProducts() {
        logger.info("Product list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getAllProducts().getBody()));
    }

    @GetMapping("/products/category/{id}")
    public ResponseEntity<Object> getProductsByCategoryId(@PathVariable("id") Integer categoryId) {
        logger.info("Product list fetched by category");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getProductsByCategoryId(categoryId).getBody()));
    }
}