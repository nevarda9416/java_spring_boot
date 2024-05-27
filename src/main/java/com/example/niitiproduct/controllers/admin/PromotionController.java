package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.models.Promotion;
import com.example.niitiproduct.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/promotions")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    /**
     * Get all  promotions
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<PromotionDTO> promotions = promotionService.getAll();
        model.addAttribute("promotions",  promotions);
        return "admin/promotions/index";
    }

    /**
     * Search by  promotion name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<PromotionDTO> promotions = promotionService.getAll();
            model.addAttribute("promotions", promotions);
        } else {
            List<Promotion> promotions = promotionService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("promotions", promotions);
        }
        model.addAttribute("promotion", new PromotionDTO());
        return "admin/promotions/index";
    }

    /**
     * Edit promotion
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<PromotionDTO> promotions = promotionService.getAll();
        model.addAttribute("promotions", promotions);
        Promotion promotion = promotionService.findById(id);
        model.addAttribute("promotion", promotion);
        return "admin/promotions/edit";
    }

    /**
     * Update promotion
     * @param promotion
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Promotion promotion) {
        promotionService.save(promotion);
        return "redirect:/admin/promotions/edit/" + promotion.getId();
    }

    /**
     * Add promotion
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("promotion", new PromotionDTO());
        return "admin/promotions/add";
    }

    /**
     * Insert promotion
     * @param promotion
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Promotion promotion) {
        promotionService.save(promotion);
        return "redirect:/admin/promotions";
    }

    /**
     * Delete promotion
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        promotionService.delete(id);
        List<PromotionDTO> promotions = promotionService.getAll();
        model.addAttribute("promotions", promotions);
        model.addAttribute("promotion", new PromotionDTO());
        return "redirect:/admin/promotions";
    }
}