package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders", indexes = {@Index(name = "index_order_id", columnList = "id")})
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "code")
    String code;
    @Column(name = "total_price")
    Float total_price;
    @Column(name = "total_amount")
    Integer total_amount;
    @Column(name = "total_tax")
    Float total_tax;
    @Column(name = "status")
    String status;
    @Column(name = "accounts_receivable")
    Float accounts_receivable;
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
    @Column(name = "province_code")
    String province_code;
    @Column(name = "province_name")
    String province_name;
    @Column(name = "district_code")
    String district_code;
    @Column(name = "district_name")
    String district_name;
    @Column(name = "sub_district_code")
    String sub_district_code;
    @Column(name = "sub_district_name")
    String sub_district_name;
    @Column(name = "payment_method")
    String payment_method;
    @Column(name = "payment_date")
    String payment_date;
    @Column(name = "total_discount_code")
    String total_discount_code;
    @Column(name = "total_discount_amount")
    Float total_discount_amount;
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

    public Order(Integer id, String code, Float total_price, Integer total_amount, Float total_tax, String status, Float accounts_receivable, String note, Integer customer_id, String shipping_method, String shipping_date, String shipping_fullname, String shipping_address, String shipping_email, Float shipping_fee, String shipping_phone, String province_code, String province_name, String district_code, String district_name, String sub_district_code, String sub_district_name, String payment_method, String payment_date, String total_discount_code, Float total_discount_amount, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.code = code;
        this.total_price = total_price;
        this.total_amount = total_amount;
        this.total_tax = total_tax;
        this.status = status;
        this.accounts_receivable = accounts_receivable;
        this.note = note;
        this.customer_id = customer_id;
        this.shipping_method = shipping_method;
        this.shipping_date = shipping_date;
        this.shipping_fullname = shipping_fullname;
        this.shipping_address = shipping_address;
        this.shipping_email = shipping_email;
        this.shipping_fee = shipping_fee;
        this.shipping_phone = shipping_phone;
        this.province_code = province_code;
        this.province_name = province_name;
        this.district_code = district_code;
        this.district_name = district_name;
        this.sub_district_code = sub_district_code;
        this.sub_district_name = sub_district_name;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.total_discount_code = total_discount_code;
        this.total_discount_amount = total_discount_amount;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
