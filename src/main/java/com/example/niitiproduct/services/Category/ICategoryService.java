package com.example.niitiproduct.services.Category;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    Page<Category> findPaginated(int page, int size);
    List<CategoryDTO> getAll(Pageable pageable);

    Page<Category> searchByName(String name, int page, int size);

    Category findById(Long id);

    boolean store(Category category);

    boolean save(Category category);

    void delete(Long id);

    ResponseEntity<Object> getAllCategories();
}
