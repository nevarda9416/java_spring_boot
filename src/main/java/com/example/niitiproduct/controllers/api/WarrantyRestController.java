package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WarrantyRestController {
    @Autowired
    private WarrantyService warrantyService;

    @GetMapping("/warranties/all")
    public ResponseEntity<Object> index() {
        return warrantyService.getAllWarranties();
    }
}
