package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String short_description;
    String long_description;
    String thumbnail_url;
    String unit;
    String status;
    String sku;
    Integer category_id;
    Integer display_order;
    String meta_title;
    String meta_keyword;
    String meta_description;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
