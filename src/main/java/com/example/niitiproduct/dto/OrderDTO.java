package com.example.niitiproduct.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Integer id;
    private String code;
    private Float total_price;
    private Integer total_amount;
    private Float total_tax;
    private String status;
    private Float accounts_receivable;
    private String note;
    private Integer customer_id;
    private String shipping_method;
    private String shipping_date;
    private String shipping_fullname;
    private String shipping_address;
    private String shipping_email;
    private Float shipping_fee;
    private String shipping_phone;
    private String province_code;
    private String province_name;
    private String district_code;
    private String district_name;
    private String sub_district_code;
    private String sub_district_name;
    private String payment_method;
    private String payment_date;
    private String total_discount_code;
    private Float total_discount_amount;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
    private List<ProductDTO> productList;
}
