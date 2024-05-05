package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.dto.ProductList;
import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProducts() {
        logger.info("Product list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getAllProducts().getBody()));
    }

    @GetMapping("/category/id/{id}")
    public ResponseEntity<Object> getProductsByCategoryId(@PathVariable("id") Integer id) {
        logger.info("Product list fetched by category ID");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getProductsByCategoryId(id).getBody()));
    }

    @GetMapping("/category/slug/{slug}")
    public ResponseEntity<Object> getProductsByCategorySlug(@PathVariable("slug") String slug) {
        logger.info("Product list fetched by category slug");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getProductsByCategorySlug(slug).getBody()));
    }


    @PostMapping("/list")
    public ResponseEntity<Object> getListProductsByIds(@RequestBody ProductList product) {
        logger.info("List product details fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getListProductDetails(product.getProductList()).getBody()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
        logger.info("Product detail by ID");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getProductById(id).getBody()));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<Object> getProductBySlug(@PathVariable("slug") String slug) {
        logger.info("Product detail by slug");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(productService.getProductBySlug(slug).getBody()));
    }
}