package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.SellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SellingPlaceRestController {
    @Autowired
    private SellingPlaceService sellingPlaceService;

    @GetMapping("/selling_places/all")
    public ResponseEntity<Object> index() {
        return sellingPlaceService.getAllSellingPlaces();
    }
}