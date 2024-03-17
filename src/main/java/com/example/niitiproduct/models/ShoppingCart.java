package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="shopping_carts", indexes={@Index(name="index_shopping_cart_id", columnList="id")})
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "identifier")
    String identifier;
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
    String shipping_fee;
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
    @Column(name = "customer_note")
    String customer_note;
    @Column(name = "payment_method")
    String payment_method;
    @Column(name = "payment_date")
    String payment_date;
    @Column(name = "discount_code")
    String discount_code;
    @Column(name = "discount_amount")
    Float discount_amount;
    @Column(name = "order_value")
    Float order_value;
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

    public ShoppingCart(Integer id, String identifier, String note, Integer customer_id, String shipping_method, String shipping_date, String shipping_fullname, String shipping_address, String shipping_email, String shipping_fee, String shipping_phone, Integer province_id, String province_name, Integer district_id, String district_name, Integer sub_district_id, String sub_district_name, String customer_note, String payment_method, String payment_date, String discount_code, Float discount_amount, Float order_value, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.identifier = identifier;
        this.note = note;
        this.customer_id = customer_id;
        this.shipping_method = shipping_method;
        this.shipping_date = shipping_date;
        this.shipping_fullname = shipping_fullname;
        this.shipping_address = shipping_address;
        this.shipping_email = shipping_email;
        this.shipping_fee = shipping_fee;
        this.shipping_phone = shipping_phone;
        this.province_id = province_id;
        this.province_name = province_name;
        this.district_id = district_id;
        this.district_name = district_name;
        this.sub_district_id = sub_district_id;
        this.sub_district_name = sub_district_name;
        this.customer_note = customer_note;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.discount_code = discount_code;
        this.discount_amount = discount_amount;
        this.order_value = order_value;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
