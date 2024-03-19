package com.example.niitiproduct.services;

import com.example.niitiproduct.models.Ward;
import com.example.niitiproduct.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {
    @Autowired
    private WardRepository wardRepository;

    public ResponseEntity<Object> getAllWards() {
        List<Ward> wardList = wardRepository.findAll();
        return new ResponseEntity<>(wardList, HttpStatus.OK);
    }

    public ResponseEntity<Object> getWardsByDistrictCode(String code) {
        List<Ward> wardList = wardRepository.findWardsByDistrictCode(code);
        return new ResponseEntity<>(wardList, HttpStatus.OK);
    }
}
