package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BannerRestController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("/banners/all")
    public ResponseEntity<Object> index() {
        return bannerService.getAllBanners();
    }
}