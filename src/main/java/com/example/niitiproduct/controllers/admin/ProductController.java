package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.config.constants.Pagination;
import com.example.niitiproduct.dto.*;
import com.example.niitiproduct.models.Product;
import com.example.niitiproduct.services.Category.CategoryService;
import com.example.niitiproduct.services.ManufactureService;
import com.example.niitiproduct.services.ProductService;
import com.example.niitiproduct.services.PromotionService;
import com.example.niitiproduct.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("admin/products")
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private ManufactureService manufactureService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PromotionService promotionService;

    /**
     * Get all products
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<ProductDTO> products = productService.getAll();
        List<PromotionDTO> promotions = promotionService.getAll();
        model.addAttribute("products", products);
        model.addAttribute("promotions", promotions);
        return "admin/product/index";
    }

    /**
     * Search by product name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<ProductDTO> products = productService.getAll();
            model.addAttribute("products", products);
        } else {
            List<Product> products = productService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("products", products);
        }
        model.addAttribute("product", new ProductDTO());
        return "admin/product/index";
    }

    /**
     * Edit product
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        Pageable pageable = Pageable.ofSize(Integer.parseInt(Pagination.largeSize)).withPage(Integer.parseInt(Pagination.defaultPage) - 1);
        List<CategoryDTO> categories = categoryService.getAll(pageable);
        model.addAttribute("categories", categories);
        List<SubCategoryDTO> subcategories = subCategoryService.getAll();
        model.addAttribute("subcategories", subcategories);
        List<ManufactureDTO> manufactures = manufactureService.getAll();
        model.addAttribute("manufactures", manufactures);
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "admin/product/edit";
    }

    /**
     * Update product
     * @param product
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/admin/products/edit/" + product.getId();
    }

    /**
     * Add product
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        Pageable pageable = Pageable.ofSize(Integer.parseInt(Pagination.largeSize)).withPage(Integer.parseInt(Pagination.defaultPage) - 1);
        List<CategoryDTO> categories = categoryService.getAll(pageable);
        model.addAttribute("categories", categories);
        List<SubCategoryDTO> subcategories = subCategoryService.getAll();
        model.addAttribute("subcategories", subcategories);
        List<ManufactureDTO> manufactures = manufactureService.getAll();
        model.addAttribute("manufactures", manufactures);
        model.addAttribute("product", new ProductDTO());
        return "admin/product/add";
    }

    /**
     * Insert product
     * @param product
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/admin/products";
    }

    /**
     * Delete product
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        productService.delete(id);
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new ProductDTO());
        return "redirect:/admin/categories";
    }
}