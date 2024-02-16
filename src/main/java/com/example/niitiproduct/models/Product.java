package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    String name;
    @Column(name = "short_description")
    String short_description;
    @Column(name = "long_description")
    String long_description;
    @Column(name = "status")
    String status;
    @Column(name = "category_id")
    Integer category_id;
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
}
