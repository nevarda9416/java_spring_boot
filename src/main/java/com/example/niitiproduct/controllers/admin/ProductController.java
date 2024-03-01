package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.models.Product;
import com.example.niitiproduct.models.ProductPromotion;
import com.example.niitiproduct.services.CategoryService;
import com.example.niitiproduct.services.ProductService;
import com.example.niitiproduct.services.PromotionService;
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
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
        List<ProductPromotion> promotion = productService.findById(id);
        model.addAttribute("promotion", promotion);
        return "admin/product/index";
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
        Pageable pageable = Pageable.ofSize(100).withPage(0);
        List<CategoryDTO> categories = categoryService.getAll(pageable);
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("products", products);
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