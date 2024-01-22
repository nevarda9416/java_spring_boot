package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder(
                ).id(category.getId())
                .name(category.getA_name())
                .image(category.getB_image())
                .summary(category.getC_summary())
                .description(category.getD_description())
                .display_order(category.getE_display_order())
                .is_actived(category.getF_is_actived())
                .created_at(category.getG_created_at())
                .created_by(category.getH_created_by())
                .updated_at(category.getI_updated_at())
                .updated_by(category.getJ_updated_by())
                .deleted_at(category.getK_deleted_at())
                .deleted_by(category.getL_deleted_by())
                .build();
    }
}
