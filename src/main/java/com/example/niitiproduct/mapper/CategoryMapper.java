package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder(
                ).id(category.getId())
                .name(category.getC00_name())
                .image(category.getC01_image())
                .summary(category.getC02_summary())
                .description(category.getC03_description())
                .display_order(category.getC04_display_order())
                .is_actived(category.getC05_is_actived())
                .created_at(category.getC06_created_at())
                .created_by(category.getC07_created_by())
                .updated_at(category.getC08_updated_at())
                .updated_by(category.getC09_updated_by())
                .deleted_at(category.getC10_deleted_at())
                .deleted_by(category.getC11_deleted_by())
                .build();
    }
}
