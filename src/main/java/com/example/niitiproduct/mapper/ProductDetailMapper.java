package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ProductDetailDTO;
import com.example.niitiproduct.models.ProductDetail;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapper {
    public ProductDetailDTO toDTO(ProductDetail productDetail) {
        return ProductDetailDTO.builder(
                ).id(productDetail.getId())
                .list_attribute_ids(productDetail.getList_attribute_ids())
                .original_price(productDetail.getOriginal_price())
                .sale_price(productDetail.getSale_price())
                .product_id(productDetail.getProduct_id())
                .sku(productDetail.getSku())
                .thumbnail_url(productDetail.getThumbnail_url())
                .status(productDetail.getStatus())
                .created_at(productDetail.getCreated_at())
                .created_by(productDetail.getCreated_by())
                .updated_at(productDetail.getUpdated_at())
                .updated_by(productDetail.getUpdated_by())
                .deleted_at(productDetail.getDeleted_at())
                .deleted_by(productDetail.getDeleted_by())
                .build();
    }
}
