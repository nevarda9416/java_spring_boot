package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_items", indexes={@Index(name="index_order_item_id", columnList="id,order_id,product_id")})
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "order_id")
    Integer order_id;
    @Column(name = "product_id")
    Integer product_id;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "price")
    Float price;
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

    public OrderItem(Integer id, Integer order_id, Integer product_id, Integer quantity, Float price, String discount_code, Float discount_amount, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.discount_code = discount_code;
        this.discount_amount = discount_amount;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}

