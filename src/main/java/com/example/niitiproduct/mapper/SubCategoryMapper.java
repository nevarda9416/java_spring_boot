package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.models.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryMapper {
    public SubCategoryDTO toDTO(SubCategory category) {
        return SubCategoryDTO.builder(
                ).id(category.getId())
                .name(category.getS00_name())
                .image(category.getS01_image())
                .summary(category.getS02_summary())
                .description(category.getS03_description())
                .display_order(category.getS04_display_order())
                .is_actived(category.getS05_is_actived())
                .category_id(category.getS06_category_id())
                .created_at(category.getS07_created_at())
                .created_by(category.getS08_created_by())
                .updated_at(category.getS09_updated_at())
                .updated_by(category.getS10_updated_by())
                .deleted_at(category.getS11_deleted_at())
                .deleted_by(category.getS12_deleted_by())
                .build();
    }
}