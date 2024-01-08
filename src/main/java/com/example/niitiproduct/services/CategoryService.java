package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.mapper.CategoryMapper;
import com.example.niitiproduct.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(e->categoryMapper.toDTO(e)).toList();
    }
}
