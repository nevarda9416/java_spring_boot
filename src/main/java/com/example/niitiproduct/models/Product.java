package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products", indexes={@Index(name="index_product_id", columnList="id")})
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "slug")
    String slug;
    @Column(name = "summary", columnDefinition = "TEXT")
    String summary;
    @Column(name = "short_description", columnDefinition = "TEXT")
    String short_description;
    @Column(name = "long_description", columnDefinition = "TEXT")
    String long_description;
    @Column(name = "category_id")
    Integer category_id;
    @Column(name = "sub_category_id")
    Integer sub_category_id;
    @Column(name = "manufacture_id")
    Integer manufacture_id;
    @Column(name = "display_order")
    Integer display_order;
    @Column(name = "meta_title")
    String meta_title;
    @Column(name = "meta_keyword")
    String meta_keyword;
    @Column(name = "meta_description")
    String meta_description;
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
//    @ManyToMany
//    @JoinTable(name="products_promotions",
//    joinColumns = {@JoinColumn(name="product_id")},
//    inverseJoinColumns = {@JoinColumn(name = "promotion_id")})
//    Set<Promotion> promotionList = new HashSet<>();

    public Product(Integer id, String name, String slug, String summary, String short_description, String long_description, Integer category_id, Integer sub_category_id, Integer manufacture_id, Integer display_order, String meta_title, String meta_keyword, String meta_description, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.summary = summary;
        this.short_description = short_description;
        this.long_description = long_description;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.manufacture_id = manufacture_id;
        this.display_order = display_order;
        this.meta_title = meta_title;
        this.meta_keyword = meta_keyword;
        this.meta_description = meta_description;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
