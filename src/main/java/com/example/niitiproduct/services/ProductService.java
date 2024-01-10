package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.mapper.ProductMapper;
import com.example.niitiproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(e->productMapper.toDTO(e)).toList();
    }
}
