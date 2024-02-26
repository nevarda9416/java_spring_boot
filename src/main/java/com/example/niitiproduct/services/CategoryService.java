package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.mapper.CategoryMapper;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Page<Category> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.categoryRepository.findAll(pageable);
    }

    public List<CategoryDTO> getAll(Pageable pageable) {
        return categoryRepository.findAllByOrderByIdDesc(pageable).stream().map(e->categoryMapper.toDTO(e)).toList();
    }

    public Page<Category> searchByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.categoryRepository.findByNameContaining(name, pageable);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(Math.toIntExact(id)).get();
    }

    public boolean store(Category category) {
        categoryRepository.save(category);
        return true;
    }

    public boolean save(Category category) {
        try {
            Category categoryData = new Category();
            categoryData.setId(category.getId());
            categoryData.setName(category.getName());
            categoryData.setImage(String.valueOf(category.getImage()));
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

    public ResponseEntity<Object> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}




