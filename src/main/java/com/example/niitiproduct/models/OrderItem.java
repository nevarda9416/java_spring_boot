package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_items", indexes={@Index(name="index_order_item_id", columnList="id,order_id,product_id")})
@AllArgsConstructor
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

