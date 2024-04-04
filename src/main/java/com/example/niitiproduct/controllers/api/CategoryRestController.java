package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/all")
    public ResponseEntity<Object> index() {
        return categoryService.getAllCategories();
    }
}
