package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDTO {
    private Integer id;
    private String list_attribute_ids;
    private Float original_price;
    private Float sale_price;
    private Integer product_id;
    private String sku;
    private String thumbnail_url;
    private String status;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
