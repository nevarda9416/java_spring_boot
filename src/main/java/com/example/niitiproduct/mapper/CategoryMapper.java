package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder(
                ).id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .summary(category.getSummary())
                .description(category.getDescription())
                .display_order(category.getDisplay_order())
                .is_actived(category.getIs_actived())
                .created_at(category.getCreated_at())
                .created_by(category.getCreated_by())
                .updated_at(category.getUpdated_at())
                .updated_by(category.getUpdated_by())
                .deleted_at(category.getDeleted_at())
                .deleted_by(category.getDeleted_by())
                .build();
    }
}
