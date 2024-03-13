package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("api")
public class SubCategoryRestController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("sub_categories/all")
    public ResponseEntity<Object> index() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("sub_categories/category/{category_id}")
    public ResponseEntity<Object> getListByCategoryId(@PathVariable("category_id") Integer categoryId) {
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(subCategoryService.getListSubCategoriesByCategoryId(categoryId).getBody()));
    }
}
