package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ProvinceRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces/all")
    public ResponseEntity<Object> getAllProvinces() {
        logger.info("Province list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(provinceService.getAllProvinces().getBody()));
    }

    @GetMapping("/provinces/region/{id}")
    public ResponseEntity<Object> getProvincesByRegionId(@PathVariable("id") Integer regionId) {
        logger.info("Province list fetched by region");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(provinceService.getProvincesByRegionId(regionId).getBody()));
    }
}
