package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="promotions", indexes={@Index(name="index_promotion_id", columnList="id")})
@NoArgsConstructor
@Getter
@Setter
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "discount_type")
    String discount_type;
    @Column(name = "discount_price")
    String discount_price;
    @Column(name = "discount_rate")
    String discount_rate;
    @Column(name = "start_time")
    String start_time;
    @Column(name = "end_time")
    String end_time;
    @Column(name = "is_actived")
    Integer is_actived;
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
//    @ManyToMany(mappedBy = "promotionList")
//    List<Product> productList;


    public Promotion(Integer id, String name, String description, String discount_type, String discount_price, String discount_rate, String start_time, String end_time, Integer is_actived, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount_type = discount_type;
        this.discount_price = discount_price;
        this.discount_rate = discount_rate;
        this.start_time = start_time;
        this.end_time = end_time;
        this.is_actived = is_actived;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
