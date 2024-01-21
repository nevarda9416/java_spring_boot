package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Integer id;
    private Integer user_id;
    private Float total_price;
    private Integer total_amount;
    private Float total_tax;
    private String status;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
