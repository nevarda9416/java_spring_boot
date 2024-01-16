package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SellingPlaceDTO;
import com.example.niitiproduct.mapper.SellingPlaceMapper;
import com.example.niitiproduct.repositories.SellingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellingPlaceService {
    @Autowired
    SellingPlaceMapper sellingPlaceMapper;
    @Autowired
    private SellingPlaceRepository sellingPlaceRepository;
    public List<SellingPlaceDTO> getAll() {
        return sellingPlaceRepository.findAll().stream().map(e->sellingPlaceMapper.toDTO(e)).toList();
    }
}