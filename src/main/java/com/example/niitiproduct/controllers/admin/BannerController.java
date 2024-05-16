package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.BannerDTO;
import com.example.niitiproduct.models.Banner;
import com.example.niitiproduct.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/banners")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * Get all banners
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<BannerDTO> banners = bannerService.getAll();
        model.addAttribute("banners", banners);
        return "admin/banner/index";
    }

    /**
     * Search by banner name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<BannerDTO> banners = bannerService.getAll();
            model.addAttribute("banners", banners);
        } else {
            List<Banner> banners = bannerService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("banners", banners);
        }
        model.addAttribute("banner", new BannerDTO());
        return "admin/banner/index";
    }/**
     * Edit customer
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<BannerDTO> banners = bannerService.getAll();
        model.addAttribute("banners", banners);
        Banner banner = bannerService.findById(id);
        model.addAttribute("banner", banner);
        return "edit";
    }

    /**
     * Update customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Banner banner) {
        bannerService.save(banner);
        return "redirect:/admin/banners/edit/" + banner.getId();
    }

    /**
     * Add customer
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<BannerDTO> banners = bannerService.getAll();
        model.addAttribute("banners", banners);
        return "admin/banners/add";
    }

    /**
     * Insert customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Banner banner) {
        bannerService.save(banner);
        return "redirect:/admin/banners";
    }

    /**
     * Delete customer
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        bannerService.delete(id);
        List<BannerDTO> banners = bannerService.getAll();
        model.addAttribute("banners", banners);
        model.addAttribute("banner", new BannerDTO());
        return "redirect:/admin/banners";
    }
}