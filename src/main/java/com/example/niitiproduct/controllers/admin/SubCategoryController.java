package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.services.CategoryService;
import com.example.niitiproduct.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.List;

@Controller
@RequestMapping("admin")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/subcategories")
    public String index(Model model) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        return "admin/subcategory/index";
    }
}