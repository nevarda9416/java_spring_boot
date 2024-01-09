package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.models.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryMapper {
    public SubCategoryDTO toDTO(SubCategory category) {
        return SubCategoryDTO.builder(
                ).id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .summary(category.getSummary())
                .description(category.getDescription())
                .display_order(category.getDisplay_order())
                .is_actived(category.getIs_actived())
                .category_id(category.getCategory_id())
                .created_at(category.getCreated_at())
                .created_by(category.getCreated_by())
                .updated_at(category.getUpdated_at())
                .updated_by(category.getUpdated_by())
                .deleted_at(category.getDeleted_at())
                .deleted_by(category.getDeleted_by())
                .build();
    }
}