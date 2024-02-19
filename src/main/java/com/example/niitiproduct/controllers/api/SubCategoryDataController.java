package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SubCategoryDataController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/sub_categories/all")
    public ResponseEntity<Object> index() {
        return subCategoryService.getAllSubCategories();
    }
}
