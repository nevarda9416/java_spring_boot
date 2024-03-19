package com.example.niitiproduct.services;

import com.example.niitiproduct.models.Province;
import com.example.niitiproduct.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public ResponseEntity<Object> getAllProvinces() {
        List<Province> provinceList = provinceRepository.findAll();
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    public ResponseEntity<Object> getProvincesByRegionId(Integer regionId) {
        List<Province> provinceList = provinceRepository.findProvincesByAdministrative_region_id(regionId);
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }
}
