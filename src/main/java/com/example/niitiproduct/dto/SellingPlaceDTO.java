package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellingPlaceDTO {
    private Integer id;
    private String name;
    private String area;
    private String city;
    private String district;
    private String sub_district;
    private String address;
    private String hotline;
    private String status;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
