package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder(
                ).id(product.getId())
                .name(product.getName())
                .short_description(product.getShort_description())
                .long_description(product.getLong_description())
                .category_id(product.getCategory_id())
                .sub_category_id(product.getSub_category_id())
                .display_order(product.getDisplay_order())
                .meta_title(product.getMeta_title())
                .meta_keyword(product.getMeta_keyword())
                .meta_description(product.getMeta_description())
                .created_at(product.getCreated_at())
                .created_by(product.getCreated_by())
                .updated_at(product.getUpdated_at())
                .updated_by(product.getUpdated_by())
                .deleted_at(product.getDeleted_at())
                .deleted_by(product.getDeleted_by())
                .promotionList(new PromotionDTO())
                .build();
    }
}
