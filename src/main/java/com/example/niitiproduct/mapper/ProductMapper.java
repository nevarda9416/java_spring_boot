package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder(
                ).id(product.getId())
                .name(product.getP00_name())
                .short_description(product.getP01_short_description())
                .long_description(product.getP02_long_description())
                .thumbnail_url(product.getP03_thumbnail_url())
                .unit(product.getP04_unit())
                .status(product.getP05_status())
                .sku(product.getP06_sku())
                .category_id(product.getP07_category_id())
                .display_order(product.getP08_display_order())
                .meta_title(product.getP09_meta_title())
                .meta_keyword(product.getP10_meta_keyword())
                .meta_description(product.getP11_meta_description())
                .created_at(product.getP12_created_at())
                .created_by(product.getP13_created_by())
                .updated_at(product.getP14_updated_at())
                .updated_by(product.getP15_updated_by())
                .deleted_at(product.getP16_deleted_at())
                .deleted_by(product.getP17_deleted_by())
                .build();
    }
}
