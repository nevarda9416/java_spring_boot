package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartDTO {
    private Integer id;
    private String identifier;
    private String note;
    private Integer customer_id;
    private String shipping_method;
    private String shipping_date;
    private String shipping_fullname;
    private String shipping_address;
    private String shipping_email;
    private String shipping_fee;
    private String shipping_phone;
    private Integer province_id;
    private String province_name;
    private Integer district_id;
    private String district_name;
    private Integer sub_district_id;
    private String sub_district_name;
    private String customer_note;
    private String payment_method;
    private String payment_date;
    private String discount_code;
    private Float discount_amount;
    private Float order_value;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
