package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

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
    String p00_name;
    @Column(name = "description")
    String p01_description;
    @Column(name = "discount_type")
    String p02_discount_type;
    @Column(name = "discount_price")
    String p03_discount_price;
    @Column(name = "discount_rate")
    String p04_discount_rate;
    @Column(name = "start_time")
    String p05_start_time;
    @Column(name = "end_time")
    String p06_end_time;
    @Column(name = "is_actived")
    Integer p07_is_actived;
    @Column(name = "created_at")
    String p08_created_at;
    @Column(name = "created_by")
    String p09_created_by;
    @Column(name = "updated_at")
    String p10_updated_at;
    @Column(name = "updated_by")
    String p11_updated_by;
    @Column(name = "deleted_at")
    String p12_deleted_at;
    @Column(name = "deleted_by")
    String p13_deleted_by;
}
