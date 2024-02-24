package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_details", indexes={@Index(name="index_product_detail_id", columnList="id,product_id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "attribute_value")
    String attribute_value;
    @Column(name = "original_price")
    Float original_price;
    @Column(name = "sale_price")
    Float sale_price;
    @Column(name = "product_id")
    Integer product_id;
    @Column(name = "sku")
    String sku;
    @Column(name = "thumbnail_url")
    String thumbnail_url;
    @Column(name = "status")
    String status;
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
