package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.mapper.PromotionMapper;
import com.example.niitiproduct.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    PromotionMapper promotionMapper;
    @Autowired
    private PromotionRepository promotionRepository;
    public List<PromotionDTO> getAll() {
        return promotionRepository.findAll().stream().map(e->promotionMapper.toDTO(e)).toList();
    }
}
