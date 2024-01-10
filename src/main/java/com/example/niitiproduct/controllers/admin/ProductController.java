package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.services.CategoryService;
import com.example.niitiproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.List;

@Controller
@RequestMapping("admin")
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String index(Model model) {
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
        return "admin/product/index";
    }

    @GetMapping("/products/add")
    public String add(Model model) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "admin/product/add";
    }
}