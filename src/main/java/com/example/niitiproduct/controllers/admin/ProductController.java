package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.models.Product;
import com.example.niitiproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Get all products
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
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
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "admin/product/form";
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
    @GetMapping("/products/add")
    public String add(Model model) {
        List<ProductDTO> products = productService.getAll();
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