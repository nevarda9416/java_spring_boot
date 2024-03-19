package com.example.niitiproduct.services;

import com.example.niitiproduct.models.District;
import com.example.niitiproduct.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public ResponseEntity<Object> getAllDistricts() {
        List<District> districtList = districtRepository.findAll();
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    public ResponseEntity<Object> getDistrictsByProvinceCode(String code) {
        List<District> districtList = districtRepository.findDistrictsByProvinceCode(code);
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }
}

