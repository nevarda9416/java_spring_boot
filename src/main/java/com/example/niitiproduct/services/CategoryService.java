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
    public List<Category> searchByName(String name) {
        return categoryRepository.findByNameContaining(name);
    }
    public Category findById(Long id) {
        return categoryRepository.findById(Math.toIntExact(id)).get();
    }
    public boolean save(Category category) {
        try {
            Category categoryData = new Category();
            categoryData.setId(category.getId());
            categoryData.setName(category.getName());
            categoryData.setImage(category.getImage());
            categoryData.setSummary(category.getSummary());
            categoryData.setDescription(category.getDescription());
            categoryData.setDisplay_order(category.getDisplay_order());
            categoryData.setIs_actived(category.getIs_actived() != null ? category.getIs_actived() : 0);
            categoryData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            categoryData.setCreated_by(String.valueOf(1));
            categoryData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            categoryData.setUpdated_by(String.valueOf(1));
            categoryRepository.save(categoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void delete(Long id) {
        try {
        categoryRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




