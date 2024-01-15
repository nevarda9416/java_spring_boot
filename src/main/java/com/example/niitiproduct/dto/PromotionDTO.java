package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionDTO {
    private Integer id;
    private String name;
    private String description;
    private String discount_type;
    private String discount_price;
    private String discount_rate;
    private String start_time;
    private String end_time;
    private Integer is_actived;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
