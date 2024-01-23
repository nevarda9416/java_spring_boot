package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String p00_name;
    @Column(name = "short_description")
    String p01_short_description;
    @Column(name = "long_description")
    String p02_long_description;
    @Column(name = "thumbnail_url")
    String p03_thumbnail_url;
    @Column(name = "unit")
    String p04_unit;
    @Column(name = "status")
    String p05_status;
    @Column(name = "sku")
    String p06_sku;
    @Column(name = "category_id")
    Integer p07_category_id;
    @Column(name = "display_order")
    Integer p08_display_order;
    @Column(name = "meta_title")
    String p09_meta_title;
    @Column(name = "meta_keyword")
    String p10_meta_keyword;
    @Column(name = "meta_description")
    String p11_meta_description;
    @Column(name = "created_at")
    String p12_created_at;
    @Column(name = "created_by")
    String p13_created_by;
    @Column(name = "updated_at")
    String p14_updated_at;
    @Column(name = "updated_by")
    String p15_updated_by;
    @Column(name = "deleted_at")
    String p16_deleted_at;
    @Column(name = "deleted_by")
    String p17_deleted_by;
}
