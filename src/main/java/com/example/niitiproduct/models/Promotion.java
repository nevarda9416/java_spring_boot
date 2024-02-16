package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "promotions")
@AllArgsConstructor
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
}
