package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.WarrantyDTO;
import com.example.niitiproduct.mapper.WarrantyMapper;
import com.example.niitiproduct.repositories.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyService {
    @Autowired
    WarrantyMapper warrantyMapper;
    @Autowired
    private WarrantyRepository warrantyRepository;

    public List<WarrantyDTO> getAll() {
        return warrantyRepository.findAll().stream().map(e -> warrantyMapper.toDTO(e)).toList();
    }
}
