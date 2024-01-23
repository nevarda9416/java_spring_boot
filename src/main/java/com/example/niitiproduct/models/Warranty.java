package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="warranties")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "customer_id")
    Integer w00_customer_id;
    @Column(name = "order_id")
    Integer w01_order_id;
    @Column(name = "product_id")
    Integer w02_product_id;
    @Column(name = "period")
    String w03_period;
    @Column(name = "description")
    String w04_description;
    @Column(name = "created_at")
    String w05_created_at;
    @Column(name = "created_by")
    String w06_created_by;
    @Column(name = "updated_at")
    String w07_updated_at;
    @Column(name = "updated_by")
    String w08_updated_by;
    @Column(name = "deleted_at")
    String w09_deleted_at;
    @Column(name = "deleted_by")
    String w10_deleted_by;
}
