package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_details", indexes={@Index(name="index_product_detail_id", columnList="id,product_id")})
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "list_attribute_ids")
    String list_attribute_ids;
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

    public ProductDetail(Integer id, String list_attribute_ids, Float original_price, Float sale_price, Integer product_id, String sku, String thumbnail_url, String status, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.list_attribute_ids = list_attribute_ids;
        this.original_price = original_price;
        this.sale_price = sale_price;
        this.product_id = product_id;
        this.sku = sku;
        this.thumbnail_url = thumbnail_url;
        this.status = status;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
