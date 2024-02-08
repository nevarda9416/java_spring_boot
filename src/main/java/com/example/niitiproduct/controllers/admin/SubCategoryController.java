package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.models.SubCategory;
import com.example.niitiproduct.services.CategoryService;
import com.example.niitiproduct.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/subcategories")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    /**
     * Get all sub categories
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("subCategory", new SubCategoryDTO());
        return "admin/subcategory/index";
    }

    /**
     * Search by subCategory name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<SubCategoryDTO> subCategories = subCategoryService.getAll();
            model.addAttribute("subCategories", subCategories);
        } else {
            List<SubCategory> subCategories = subCategoryService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("subCategories", subCategories);
        }
        model.addAttribute("subCategory", new SubCategoryDTO());
        return "admin/subCategory/index";
    }

    /**
     * Edit subCategory
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        SubCategory subCategory = subCategoryService.findById(id);
        model.addAttribute("subCategory", subCategory);
        return "admin/subCategory/form";
    }

    /**
     * Update subCategory
     * @param subCategory
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute SubCategory subCategory) {
        subCategoryService.save(subCategory);
        return "redirect:/admin/subCategories/edit/" + subCategory.getId();
    }

    /**
     * Add subCategory
     * @param model
     * @return
     */
    @GetMapping("/subCategories/add")
    public String add(Model model) {
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        return "admin/subCategory/add";
    }

    /**
     * Insert subCategory
     * @param subCategory
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute SubCategory subCategory) {
        subCategoryService.save(subCategory);
        return "redirect:/admin/subcategories";
    }

    /**
     * Delete subCategory
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        subCategoryService.delete(id);
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("subCategory", new SubCategoryDTO());
        return "redirect:/admin/categories";
    }
}