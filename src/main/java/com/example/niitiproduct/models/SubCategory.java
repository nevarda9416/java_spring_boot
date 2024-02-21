package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="subcategories")
@NoArgsConstructor
@Getter
@Setter
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "image")
    String image;
    @Column(name = "summary")
    String summary;
    @Column(name = "description")
    String description;
    @Column(name = "display_order")
    Integer display_order;
    @Column(name = "is_actived")
    Integer is_actived;
    @Column(name = "category_id")
    Integer category_id;
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

    public SubCategory(Integer id, String name, String image, String summary, String description, Integer display_order, Integer is_actived, Integer category_id, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.description = description;
        this.display_order = display_order;
        this.is_actived = is_actived;
        this.category_id = category_id;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
