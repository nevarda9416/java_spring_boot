package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "user_id")
    Integer o00_user_id;
    @Column(name = "total_price")
    Float o01_total_price;
    @Column(name = "total_amount")
    Integer o02_total_amount;
    @Column(name = "total_tax")
    Float o03_total_tax;
    @Column(name = "status")
    String o04_status;
    @Column(name = "created_at")
    String o05_created_at;
    @Column(name = "created_by")
    String o06_created_by;
    @Column(name = "updated_at")
    String o07_updated_at;
    @Column(name = "updated_by")
    String o08_updated_by;
    @Column(name = "deleted_at")
    String o09_deleted_at;
    @Column(name = "deleted_by")
    String o10_deleted_by;
}
