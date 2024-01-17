package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.BannerDTO;
import com.example.niitiproduct.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @GetMapping("/banners")
    public String index(Model model) {
        List<BannerDTO> banners = bannerService.getAll();
        model.addAttribute("banners", banners);
        return "admin/banner/index";
    }
}