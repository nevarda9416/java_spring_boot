package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CategoryController {
@Autowired
private CategoryService categoryService;
    @GetMapping("/categories")
    public String index(Model model) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "admin/category/index";
    }
    @GetMapping("/categories/all")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<CategoryDTO> categories = categoryService.getAll();
        System.out.println("Danh mục sản phẩm: " + categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
