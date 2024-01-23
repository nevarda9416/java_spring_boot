package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="subcategories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String s00_name;
    @Column(name = "image")
    String s01_image;
    @Column(name = "summary")
    String s02_summary;
    @Column(name = "description")
    String s03_description;
    @Column(name = "display_order")
    Integer s04_display_order;
    @Column(name = "is_actived")
    Integer s05_is_actived;
    @Column(name = "category_id")
    Integer s06_category_id;
    @Column(name = "created_at")
    String s07_created_at;
    @Column(name = "created_by")
    String s08_created_by;
    @Column(name = "updated_at")
    String s09_updated_at;
    @Column(name = "updated_by")
    String s10_updated_by;
    @Column(name = "deleted_at")
    String s11_deleted_at;
    @Column(name = "deleted_by")
    String s12_deleted_by;
}
