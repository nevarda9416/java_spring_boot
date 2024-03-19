package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.WardService;
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
public class WardRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WardService wardService;

    @GetMapping("/wards/all")
    public ResponseEntity<Object> getAllDistricts() {
        logger.info("Ward list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(wardService.getAllWards().getBody()));
    }

    @GetMapping("/wards/district/{code}")
    public ResponseEntity<Object> getProvincesByRegionId(@PathVariable("code") String code) {
        logger.info("Ward list fetched by district");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(wardService.getWardsByDistrictCode(code).getBody()));
    }
}

