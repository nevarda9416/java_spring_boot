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
            categoryData.setA_name(category.getA_name());
            categoryData.setB_image(category.getB_image());
            categoryData.setC_summary(category.getC_summary());
            categoryData.setD_description(category.getD_description());
            categoryData.setF_is_actived(category.getF_is_actived() != null ? category.getF_is_actived() : 0);
            categoryData.setE_display_order(category.getE_display_order());
            categoryData.setG_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            categoryData.setH_created_by(String.valueOf(1));
            categoryData.setI_updated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            categoryData.setJ_updated_by(String.valueOf(1));
            categoryRepository.save(categoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}




