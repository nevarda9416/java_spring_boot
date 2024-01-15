package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.services.CategoryService;
import com.example.niitiproduct.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/promotions")
    public String index(Model model) {
        List<PromotionDTO> promotions = promotionService.getAll();
        model.addAttribute("promotions",  promotions);
        return "admin/promotion/index";
    }
}