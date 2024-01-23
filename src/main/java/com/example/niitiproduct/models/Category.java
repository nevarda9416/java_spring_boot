package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String c00_name;
    @Column(name = "image")
    String c01_image;
    @Column(name = "summary")
    String c02_summary;
    @Column(name = "description")
    String c03_description;
    @Column(name = "display_order")
    Integer c04_display_order;
    @Column(name = "is_actived")
    Integer c05_is_actived;
    @Column(name = "created_at")
    String c06_created_at;
    @Column(name = "created_by")
    String c07_created_by;
    @Column(name = "updated_at")
    String c08_updated_at;
    @Column(name = "updated_by")
    String c09_updated_by;
    @Column(name = "deleted_at")
    String c10_deleted_at;
    @Column(name = "deleted_by")
    String c11_deleted_by;
}
