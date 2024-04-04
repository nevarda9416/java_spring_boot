package com.example.niitiproduct.services.Category;

import com.example.niitiproduct.models.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Page<Category> findPaginated(int page, int size);
}
