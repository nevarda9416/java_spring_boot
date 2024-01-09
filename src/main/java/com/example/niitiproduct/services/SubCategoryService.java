package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.mapper.SubCategoryMapper;
import com.example.niitiproduct.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    SubCategoryMapper subCategoryMapper;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    public List<SubCategoryDTO> getAll() {
        return subCategoryRepository.findAll().stream().map(e->subCategoryMapper.toDTO(e)).toList();
    }
}
