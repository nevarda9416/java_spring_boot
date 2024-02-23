package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInventoryDTO {
    private Integer id;
    private Integer product_detail_id;
    private Integer inventory_id;
    private Integer quantity_inventory;
    private Integer selling_place_id;
    private Integer quantity_selling_place;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
