package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "order_id")
    Integer order_id;
    @Column(name = "note")
    String note;
    @Column(name = "customer_id")
    Integer customer_id;
    @Column(name = "shipping_method")
    String shipping_method;
    @Column(name = "shipping_date")
    String shipping_date;
    @Column(name = "shipping_fullname")
    String shipping_fullname;
    @Column(name = "shipping_address")
    String shipping_address;
    @Column(name = "shipping_email")
    String shipping_email;
    @Column(name = "shipping_fee")
    Float shipping_fee;
    @Column(name = "shipping_phone")
    String shipping_phone;
    @Column(name = "province_id")
    Integer province_id;
    @Column(name = "province_name")
    String province_name;
    @Column(name = "district_id")
    Integer district_id;
    @Column(name = "district_name")
    String district_name;
    @Column(name = "sub_district_id")
    Integer sub_district_id;
    @Column(name = "sub_district_name")
    String sub_district_name;
    @Column(name = "payment_method")
    String payment_method;
    @Column(name = "payment_date")
    String payment_date;
    @Column(name = "discount_code")
    String discount_code;
    @Column(name = "discount_amount")
    Float discount_amount;
    @Column(name = "created_at")
    String created_at;
    @Column(name = "created_by")
    String created_by;
    @Column(name = "updated_at")
    String updated_at;
    @Column(name = "updated_by")
    String updated_by;
    @Column(name = "deleted_at")
    String deleted_at;
    @Column(name = "deleted_by")
    String deleted_by;
}
