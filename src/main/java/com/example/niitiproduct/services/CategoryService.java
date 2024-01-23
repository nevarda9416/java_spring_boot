package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.mapper.CategoryMapper;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAllByOrderByIdDesc().stream().map(e->categoryMapper.toDTO(e)).toList();
    }
    public boolean save(Category category) {
        try {
            Category categoryData = new Category();
            categoryData.setC00_name(category.getC00_name());
            categoryData.setC01_image(category.getC01_image());
            categoryData.setC02_summary(category.getC02_summary());
            categoryData.setC03_description(category.getC03_description());
            categoryData.setC04_display_order(category.getC04_display_order());
            categoryData.setC05_is_actived(category.getC05_is_actived() != null ? category.getC05_is_actived() : 0);
            categoryData.setC06_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            categoryData.setC07_created_by(String.valueOf(1));
            categoryData.setC08_updated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            categoryData.setC09_updated_by(String.valueOf(1));
            categoryRepository.save(categoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}




