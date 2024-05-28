package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private String slug;
    private String summary;
    private String short_description;
    private String long_description;
    private Integer category_id;
    private Integer sub_category_id;
    private Integer manufacture_id;
    private Integer display_order;
    private String meta_title;
    private String meta_keyword;
    private String meta_description;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
    private PromotionDTO promotionList;
    private Float price;
    private Integer quantity;
    private String discount_code;
    private Float discount_amount;
}
