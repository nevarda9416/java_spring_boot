package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.DistrictService;
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
public class DistrictRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DistrictService districtService;

    @GetMapping("/districts/all")
    public ResponseEntity<Object> getAllDistricts() {
        logger.info("District list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(districtService.getAllDistricts().getBody()));
    }

    @GetMapping("/districts/province/{code}")
    public ResponseEntity<Object> getProvincesByRegionId(@PathVariable("code") String code) {
        logger.info("District list fetched by province");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(districtService.getDistrictsByProvinceCode(code).getBody()));
    }
}

