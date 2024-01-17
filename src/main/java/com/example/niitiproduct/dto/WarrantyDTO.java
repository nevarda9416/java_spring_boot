package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarrantyDTO {
    private Integer id;
    private Integer customer_id;
    private Integer order_id;
    private Integer product_id;
    private String period;
    private String description;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
