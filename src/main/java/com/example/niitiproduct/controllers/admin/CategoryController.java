package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.repositories.CategoryRepository;
import com.example.niitiproduct.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO());
        return "admin/category/index";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<CategoryDTO> categories = categoryService.getAll();
            model.addAttribute("categories", categories);
        } else {
            List<Category> categories = categoryService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("categories", categories);
        }
        model.addAttribute("category", new CategoryDTO());
        return "admin/category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/form";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories/edit/" + category.getId();
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        categoryService.delete(id);
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO());
        return "redirect:/admin/categories";
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<CategoryDTO> categories = categoryService.getAll();
        System.out.println("Danh mục sản phẩm: " + categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
