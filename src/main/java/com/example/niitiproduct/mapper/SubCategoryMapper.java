package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.models.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryMapper {
    public SubCategoryDTO toDTO(SubCategory subCategory) {
        return SubCategoryDTO.builder(
                ).id(subCategory.getId())
                .name(subCategory.getName())
                .image(subCategory.getImage())
                .summary(subCategory.getSummary())
                .description(subCategory.getDescription())
                .display_order(subCategory.getDisplay_order())
                .is_actived(subCategory.getIs_actived())
                .category_id(subCategory.getCategory_id())
                .created_at(subCategory.getCreated_at())
                .created_by(subCategory.getCreated_by())
                .updated_at(subCategory.getUpdated_at())
                .updated_by(subCategory.getUpdated_by())
                .deleted_at(subCategory.getDeleted_at())
                .deleted_by(subCategory.getDeleted_by())
                .build();
    }
}